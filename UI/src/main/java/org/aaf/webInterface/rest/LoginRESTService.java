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
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.aaf.dto.TeamDTO;
import org.aaf.webInterface.service.UserService;
import org.aaf.webInterface.util.Convertes;

import com.cedarsoftware.util.io.JsonWriter;

@Path("/login")
@RequestScoped
public class LoginRESTService {

	@EJB
	private UserService userService;

	@GET
	@Path("/login/{countryId:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public TeamDTO lookupAvaliableTeamByCountry(@PathParam("countryId") long id) {
		// Team t = null;
		// try {
		// t = teamService.getAvailableTeam(id);
		// if (t == null) {
		// throw new WebApplicationException(Response.Status.NOT_FOUND);
		// }
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return t;
		return null;
	}

	// TODO - importante passar senha e depois token
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response register(@QueryParam("login") String login) {

		Response.ResponseBuilder builder = Response.ok();

		try {

			builder.entity(JsonWriter.objectToJson(Convertes.getUser(userService.login(login))));

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
