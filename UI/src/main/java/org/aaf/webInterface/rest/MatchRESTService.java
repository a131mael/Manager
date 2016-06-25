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
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.aaf.dto.LineUpDTO;
import org.aaf.model.LineUp;
import org.aaf.model.Match;
import org.aaf.webInterface.service.MatchService;
import org.aaf.webInterface.util.Convertes;

import com.cedarsoftware.util.io.JsonReader;
import com.cedarsoftware.util.io.JsonWriter;

@Path("/matches")
@RequestScoped
public class MatchRESTService {

	@EJB
	private MatchService matchService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupPlayerById(@QueryParam("id") long id, @QueryParam("idTeam") long idTeam) {
		return null;
	}
	
	@GET
	@Path("/{idTeam:[0-9][0-9]*}/{session:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMatches(@PathParam("idTeam") long idTeam, @PathParam("session") int session) {
		// TODO alterar o id do time para o token
		Response.ResponseBuilder builder = null;
		
		builder = Response.ok();
		
		List<Match> matches = matchService.getMatches(idTeam, session);
		if (matches == null) {
			builder = Response.status(Response.Status.BAD_REQUEST).entity("erro");
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			builder = Response.ok();
			builder.entity(JsonWriter.objectToJson(Convertes.getMatches(matches)));
		}
		return builder.build();
	}
	
	@GET
	@Path("/lineup/{idMatch:[0-9][0-9]*}/{idTeam:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLineUpOrLastLineUp(@PathParam("idMatch") long idMatch, @PathParam("idTeam") long idTeam) {
		// TODO alterar o id do time para o token
		Response.ResponseBuilder builder = null;
		builder = Response.ok();
		
		LineUp lineUp = matchService.getLineUp(idMatch,idTeam);
		if(lineUp == null){
			lineUp = matchService.getLastLineUp(idTeam);
		}
		if (lineUp == null) {
			// eh espero que nao se encontre nenhum resultado, apenas retorna vazio
			/*builder = Response.status(Response.Status.BAD_REQUEST).entity("erro");
			throw new WebApplicationException(Response.Status.NOT_FOUND);*/
			builder.entity(null);
			
		} else {
			builder = Response.ok();
			builder.entity(JsonWriter.objectToJson(Convertes.getLineUp(lineUp)));
		}
		return builder.build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/lineup")
	public Response saveLineUp(String lineup) {
		Response.ResponseBuilder builder = null;
		try {

			LineUpDTO dto = (LineUpDTO) JsonReader.jsonToJava(lineup);
			LineUp lineUp = Convertes.getLineUp(dto);
			
			matchService.save(lineUp);

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
