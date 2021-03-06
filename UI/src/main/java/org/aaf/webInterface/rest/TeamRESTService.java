/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.aaf.webInterface.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.aaf.dto.TeamDTO;
import org.aaf.model.Stadium;
import org.aaf.model.Team;
import org.aaf.webInterface.service.TeamService;
import org.aaf.webInterface.util.Convertes;

import com.cedarsoftware.util.io.JsonReader;
import com.cedarsoftware.util.io.JsonWriter;

@Path("/teams")
@RequestScoped
public class TeamRESTService {

	@EJB
	private TeamService teamService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Team> listAllMembers() {
		// return teamService.findAllOrderedByName();
		return null;
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupMemberById(@PathParam("id") long id) {
		Response.ResponseBuilder builder = null;

		Team team = teamService.getTean(id);

		if (team == null) {
			builder = Response.status(Response.Status.BAD_REQUEST).entity("erro");
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			builder = Response.ok();
			builder.entity(team);
		}

		return builder.build();
	}

	@GET
	@Path("/avaliable/{countryId:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupAvaliableTeamByCountry(@PathParam("countryId") long id) {
		Response.ResponseBuilder builder = null;
		
		Team team = null;
		
		try {
			team = teamService.getAvailableTeam(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (team == null) {
			builder = Response.status(Response.Status.BAD_REQUEST).entity("erro");
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			builder = Response.ok();
			builder.entity(JsonWriter.objectToJson(Convertes.getTeam(team)));
		}

		return builder.build();
	}

	@GET
	@Path("/stadium/teamID/{teamId:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTeamStadium(@PathParam("teamId") long id) {
		// TODO alterar o id do time para o token
		Response.ResponseBuilder builder = null;

		Stadium stadium = teamService.getStadium(id);

		if (stadium == null) {
			builder = Response.status(Response.Status.BAD_REQUEST).entity("erro");
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			builder = Response.ok();
			builder.entity(JsonWriter.objectToJson(Convertes.getStadium(stadium)));
		}

		return builder.build();
	}
	
	@GET
	@Path("/sumSalaryPlayers/{teamId:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSumSalaryPlayers(@PathParam("teamId") long id) {
		Response.ResponseBuilder builder = null;

		Long total = teamService.getSumSalaryPlayers(id);

		if (total == null) {
			builder = Response.status(Response.Status.BAD_REQUEST).entity("erro");
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			builder = Response.ok();
			builder.entity(JsonWriter.objectToJson(total));
		}

		return builder.build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response register(String member) {

		Response.ResponseBuilder builder = null;

		try {

			TeamDTO team = (TeamDTO) JsonReader.jsonToJava(member);
			teamService.registerTeam(Convertes.getTeam(team));

			builder = Response.ok();
		} catch (ConstraintViolationException ce) {
			// Handle bean validation issues
		} catch (ValidationException e) {
			// Handle the unique constrain violation
			Map<String, String> responseObj = new HashMap<>();
			responseObj.put("email", "Email taken");
			builder = Response.status(Response.Status.CONFLICT).entity(responseObj);
		} catch (Exception e) {
			// Handle generic exceptions
			Map<String, String> responseObj = new HashMap<>();
			responseObj.put("error", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
		}
		return builder.build();
	}

}
