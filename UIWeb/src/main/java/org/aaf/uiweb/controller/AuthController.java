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

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

import org.aaf.dto.TeamDTO;
import org.aaf.dto.UserDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;

@Model
public class AuthController {

//    @Inject
//    private FacesContext facesContext;

//    @Inject
//    private UserService userRegistration;

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
            UsernamePasswordToken token = new UsernamePasswordToken(authUser.getLogin(), authUser.getSenha().toCharArray(), true);
            SecurityUtils.getSubject().login(token);

            return "team";
        } catch (Exception ex) {
        	FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Registration Fail");
//			facesContext.addMessage(null, m);
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
    
	public Object getLoggedUser() {
//        try {
//            if (SecurityUtils.getSubject().getPrincipal() != null) {
//                UserDTO user = (UserDTO) SecurityUtils.getSubject().getPrincipal();
//                return user;
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(MemberController.class.getSimpleName()).log(Level.WARNING, null, ex);
//        	ex.printStackTrace();
//        }

//        return null;
		return null;
    }

}
