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
import javax.faces.bean.ViewScoped;

import org.aaf.dto.PlayerDTO;
import org.aaf.uiweb.service.PlayerService;
import org.aaf.uiweb.util.HabilityEnum;

@Model
@ViewScoped
public class PlayerController extends AuthController {

	// @Inject
	// private FacesContext facesContext;

	private PlayerService playerService;

	private PlayerDTO player;

	@PostConstruct
	private void init() {
		playerService = new PlayerService();
		String id = getRequestParam("id");
		addAtributoSessao("id",id);
		player = id!= null? (playerService.getPlayer(Long.parseLong(id),getLoggedUser().getTeam().getId())):null;
	}

	public String dismiss(PlayerDTO player) {
		String retorno = playerService.dismiss(player.getId());
		return retorno;
	}

	public void setPlayer(PlayerDTO player) {
		this.player = player;
	}

	public PlayerDTO getPlayer() {
		return player;
	}

}
