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

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.aaf.dto.TeamDTO;
import org.aaf.webInterface.model.Player;
import org.aaf.webInterface.model.Team;
import org.aaf.webInterface.service.LeagueService;
import org.aaf.webInterface.service.PlayerService;
import org.aaf.webInterface.service.TeamService;
import org.aaf.webInterface.util.Convertes;

import com.cedarsoftware.util.io.JsonWriter;

/**
 * JAX-RS Example
 * <p/>
 * This class produces a RESTful service to read/write the contents of the
 * members table.
 */
@Path("/leagues")
@RequestScoped
public class LeagueRESTService {

	@EJB
	private LeagueService leagueService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupPlayerById(@QueryParam("id") long id, @QueryParam("idTeam") long idTeam) {
	
		return null;
	}
	
	@GET
	@Path("/{idLeague:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTeansLeague(@PathParam("idLeague") long idLeague) {
		Response.ResponseBuilder builder = null;

		List<Team> teams = leagueService.getTeams(idLeague);

		if (teams == null) {
			builder = Response.status(Response.Status.BAD_REQUEST).entity("erro");
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			builder = Response.ok();
			builder.entity(JsonWriter.objectToJson(Convertes.getTeams(teams)));
		}

		return builder.build();
	}

}