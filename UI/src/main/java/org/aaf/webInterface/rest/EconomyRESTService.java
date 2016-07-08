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

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.aaf.model.Economy;
import org.aaf.webInterface.service.EconomyService;
import org.aaf.webInterface.util.Convertes;

import com.cedarsoftware.util.io.JsonWriter;

@Path("/Economies")
@RequestScoped
public class EconomyRESTService {

	@EJB
	private EconomyService economyService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupPlayerById(@QueryParam("id") long id, @QueryParam("idTeam") long idTeam) {
		return null;
	}
	
	@GET
	@Path("/{idTeam:[0-9][0-9]*}/{session:[0-9][0-9]*}/{week:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMatches(@PathParam("idTeam") long idTeam, @PathParam("session") int session, @PathParam("week") int week) {
		Response.ResponseBuilder builder = null;
		
		builder = Response.ok();
		
		Economy economy = economyService.getEconomyBySessionWeek(idTeam, session, week);
		if (economy == null) {
			builder = Response.status(Response.Status.BAD_REQUEST).entity("erro");
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			builder = Response.ok();
			builder.entity(JsonWriter.objectToJson(Convertes.getEconomy(economy)));
		}
		return builder.build();
	}
		
	
}
