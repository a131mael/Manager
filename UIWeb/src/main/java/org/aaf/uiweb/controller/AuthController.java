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
package org.aaf.uiweb.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aaf.dto.TeamDTO;
import org.aaf.dto.UserDTO;
import org.aaf.uiweb.service.CountryService;
import org.aaf.uiweb.service.LeagueService;
import org.aaf.uiweb.service.TeamService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;

@Model
public class AuthController {

	@Inject
	private CountryService countryService;

	@Inject
	private LeagueService leagueService;
	
	@Inject
	private TeamService teamService;

	private UserDTO loggedUser;

	@Produces
	@Named
	private UserDTO authUser;

	@PostConstruct
	public void initNewMember() {
		setAuthUser(new UserDTO());
		TeamDTO team = new TeamDTO();
		getAuthUser().setTeam(team);
	}

	public String login() throws Exception {
		try {
			UsernamePasswordToken token = new UsernamePasswordToken(authUser.getLogin(),
					authUser.getSenha().toCharArray(), true);
			SecurityUtils.getSubject().login(token);

			return "team";
		} catch (Exception ex) {
		//	FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Registration Fail");
			// facesContext.addMessage(null, m);
			ex.printStackTrace();
			return "erro";
		}
	}

	public UserDTO getAuthUser() {
		return authUser;
	}

	public void setAuthUser(UserDTO authUser) {
		this.authUser = authUser;
	}

	public UserDTO getLoggedUser() {
		try {
			if (loggedUser == null) {
				if (SecurityUtils.getSubject().getPrincipal() != null) {
					System.out.println("CONSTRUIU O USUARIO LOGADO !!");
					UserDTO user = (UserDTO) SecurityUtils.getSubject().getPrincipal();
					loggedUser = user;
					loggedUser.setCountryDTO(countryService.getCountry(loggedUser.getId()));
					loggedUser.setMainLeague(leagueService.getMainLeague(loggedUser.getId()));
					loggedUser.getTeam().setStadium(teamService.getStadium(loggedUser.getTeam().getId()));
				}
			}

			return loggedUser;

		} catch (Exception ex) {
			// Logger.getLogger(MemberController.class.getSimpleName()).log(Level.WARNING,
			// null, ex);
			ex.printStackTrace();
		}

		return null;
	}

	public static String getRequestParam(String param) {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();

		return req.getParameter(param);
	}

	public void addAtributoSessao(String nome, Object valor) {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute(nome, valor);
	}

	public Object getAtributoSessao(String nome) {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		req.getRequestURL().toString();
		req.getRequestURI().toString();
		req.getContextPath();
		req.getPathInfo();
		req.getQueryString();
		req.getParameter(nome);
		req.getAttributeNames();
		req.getHeaderNames();
		req.getParameterMap();
		try {
			req.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session = (HttpSession) req.getSession();
		Object obj = session.getAttribute(nome);
		session.getAttributeNames();
		return obj;
	}

	public Object getQueryValue(String param) {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		Object obj = req.getParameter(param); 
		return obj;
	}
	
	
	public void removeAtributoSessao(String nome) {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		HttpSession session = (HttpSession) req.getSession();
		session.removeAttribute(nome);

	}
	
	public static Map<String, String> getQueryMap(String query)  
	{  
	    String[] params = query.split("&");  
	    Map<String, String> map = new HashMap<String, String>();  
	    for (String param : params)  
	    {  
	        String name = param.split("=")[0];  
	        String value = param.split("=")[1];  
	        map.put(name, value);  
	    }  
	    return map;  
	}

}
