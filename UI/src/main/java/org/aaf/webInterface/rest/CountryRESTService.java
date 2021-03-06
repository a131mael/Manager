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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.aaf.model.Country;
import org.aaf.model.Region;
import org.aaf.model.Stadium;
import org.aaf.model.Team;
import org.aaf.webInterface.service.CountryService;
import org.aaf.webInterface.util.Convertes;

import com.cedarsoftware.util.io.JsonWriter;

@Path("/countries")
@RequestScoped
public class CountryRESTService {

	@EJB
	private CountryService countryService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getall() {
		// TODO alterar o id do time para o token
		Response.ResponseBuilder builder = null;

		List<Country> countries = countryService.findAllOrderedByName();

		if (countries == null) {
			builder = Response.status(Response.Status.BAD_REQUEST).entity("erro");
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			builder = Response.ok();
			builder.entity(JsonWriter.objectToJson(Convertes.getCountries(countries)));
		}

		return builder.build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupCountryById(@PathParam("id") long id) {
		Response.ResponseBuilder builder = Response.ok();

		Country country = countryService.findById(id);
		builder.entity(country);
		if (country == null) {
			builder = Response.status(Response.Status.NOT_FOUND);
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return builder.build();
	}

	@GET
	@Path("/user/{idUser:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupCountryByIdUser(@PathParam("idUser") long idUser) {
		Response.ResponseBuilder builder = Response.ok();

		Country country = countryService.findByUserId(idUser);
		builder.entity(JsonWriter.objectToJson(Convertes.getCountry(country)));
		if (country == null) {
			builder = Response.status(Response.Status.NOT_FOUND);
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return builder.build();
	}
	
	@GET
	@Path("/regions/{idCountry:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRegionsByContryID(@PathParam("idCountry") long idContry) {
		Response.ResponseBuilder builder = Response.ok();

		List<Region> regions = countryService.getRegions(idContry);
		builder.entity(JsonWriter.objectToJson(Convertes.getRegions(regions)));
		if (regions == null) {
			builder = Response.status(Response.Status.NOT_FOUND);
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return builder.build();
	}

}
	