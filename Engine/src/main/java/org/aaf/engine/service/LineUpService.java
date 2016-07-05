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
package org.aaf.engine.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.aaf.model.LineUp;
import org.aaf.model.Match;
import org.aaf.model.Player;
import org.aaf.model.PositionEnum;
import org.aaf.model.Team;

@Stateless
public class LineUpService {

	@PersistenceContext(unitName = "PostgresDS")
	private EntityManager em;

	@Inject
	private PlayerService playerService;

	public LineUp getLineUp(long idMatch, long idTeam) {
		StringBuilder sql = new StringBuilder();
		sql.append("Select lu from LineUp lu  ");
		sql.append("left join lu.team t ");
		sql.append("left join lu.match m ");
		sql.append("where 1=1 ");
		sql.append("and (");
		sql.append("t.id = :idTeam ");
		sql.append("and m.id = :idMatch ");
		sql.append(") ");
		Query query = em.createQuery(sql.toString());
		query.setParameter("idMatch", idMatch);
		query.setParameter("idTeam", idTeam);

		LineUp lineUp = null;
		try {
			lineUp = (LineUp) query.getSingleResult();

		} catch (NoResultException nre) {
			System.out.println("Escalação nâo encontrada.");
		}

		return lineUp;
	}

	public LineUp save(LineUp lineUp) {
		if(lineUp.getMatch() != null){
			em.find(Match.class, lineUp.getMatch().getId());
		}
		em.find(Team.class, lineUp.getTeam().getId());

		if (lineUp.getId() != null) {
			em.merge(lineUp);
		} else {
			em.persist(lineUp);
		}
		return lineUp;
	}

	public LineUp getLastLineUp(long idTeam) {
		LineUp lineUp = null;
		System.out.println("XXXXXXX");
		LocalDateTime lastDate = getDateLastLineUp(idTeam);
		System.out.println("YYYYYYY ");
		System.out.println("YYYYYYY " + lastDate);
		if (lastDate != null) {
			StringBuilder sql = new StringBuilder();
			sql.append("Select lu from LineUp lu  ");
			sql.append("left join lu.team t ");
			sql.append("left join lu.match m ");
			sql.append("where 1=1 ");
			sql.append("and (");
			sql.append("t.id = :idTeam ");
			sql.append("and lu.date = :lastDate ");
			sql.append(") ");
			Query query = em.createQuery(sql.toString());
			query.setParameter("idTeam", idTeam);
			query.setParameter("lastDate", lastDate);

			try {
				lineUp = (LineUp) query.getSingleResult();

			} catch (NoResultException nre) {
				System.out.println("Escalação nâo encontrada.");
			}
			System.out.println("kkkkkkk ");
		}
		return lineUp;
	}

	public LocalDateTime getDateLastLineUp(Long idTeam) {
		StringBuilder sql = new StringBuilder();
		sql.append("Select max(lu.date) from LineUp lu  ");
		sql.append("left join lu.team t ");
		sql.append("where 1=1 ");
		sql.append("and ");
		sql.append("t.id = :idTeam ");
		Query query = em.createQuery(sql.toString());
		query.setParameter("idTeam", idTeam);

		System.out.println("QUERY: " + sql);

		LocalDateTime date = null;
		try {
			date = (LocalDateTime) query.getSingleResult();

		} catch (NoResultException nre) {
			System.out.println("Nenhuma Escalacao encontrada");
		}

		return date;
	}

	public LineUp doLineUp(Team team) {
		LineUp lineUp = new LineUp();

		lineUp.setOrderP1(PositionEnum.GK);
		lineUp.setOrderP2(PositionEnum.DEF);
		lineUp.setOrderP3(PositionEnum.DEF);
		lineUp.setOrderP4(PositionEnum.DEF);
		lineUp.setOrderP5(PositionEnum.DEF);

		lineUp.setOrderP6(PositionEnum.MID);
		lineUp.setOrderP7(PositionEnum.MID);
		lineUp.setOrderP8(PositionEnum.MID);
		lineUp.setOrderP9(PositionEnum.MID);

		lineUp.setOrderP10(PositionEnum.ATT);
		lineUp.setOrderP11(PositionEnum.ATT);

		lineUp.setOrderP12(PositionEnum.GK);
		lineUp.setOrderP13(PositionEnum.DEF);
		lineUp.setOrderP14(PositionEnum.DEF);
		lineUp.setOrderP15(PositionEnum.MID);
		lineUp.setOrderP16(PositionEnum.ATT);

		List<Player> ordered = orderPlayerByPosition(playerService.getPlayers(team.getId(), null, null));
		lineUp.setPosition1(ordered.get(0));
		lineUp.setPosition2(ordered.get(1));
		lineUp.setPosition3(ordered.get(2));
		lineUp.setPosition4(ordered.get(3));
		lineUp.setPosition5(ordered.get(4));
		lineUp.setPosition6(ordered.get(5));
		lineUp.setPosition7(ordered.get(6));
		lineUp.setPosition8(ordered.get(7));
		lineUp.setPosition9(ordered.get(8));
		lineUp.setPosition10(ordered.get(9));
		lineUp.setPosition11(ordered.get(10));
		lineUp.setPosition12(ordered.get(11));
		lineUp.setPosition13(ordered.get(12));
		lineUp.setPosition14(ordered.get(13));
		lineUp.setPosition15(ordered.get(14));
		lineUp.setPosition16(ordered.get(15));

		em.persist(lineUp);

		return lineUp;

	}

	private List<Player> orderPlayerByPosition(List<Player> jogadores) {
		List<Player> jogadoresOrdenador = new ArrayList<>();
		List<Player> alreadyAdd = new ArrayList<>();

		Player gk = getGoalkeeper(jogadores);
		alreadyAdd.add(gk);

		List<Player> atts = getPlayers(jogadores, alreadyAdd, PositionEnum.ATT);
		alreadyAdd.addAll(atts);
		List<Player> defs = getPlayers(jogadores, alreadyAdd, PositionEnum.DEF);
		alreadyAdd.addAll(defs);
		List<Player> mids = getPlayers(jogadores, alreadyAdd, PositionEnum.MID);
		alreadyAdd.addAll(mids);
		List<Player> reserv = getPlayers(jogadores, alreadyAdd, PositionEnum.DEF);
		alreadyAdd.addAll(reserv);
		List<Player> reserv2 = getPlayers(jogadores, alreadyAdd, PositionEnum.ATT);
		alreadyAdd.addAll(reserv2);
		
		jogadoresOrdenador.add(gk);
		jogadoresOrdenador.addAll(defs);
		jogadoresOrdenador.addAll(mids);
		jogadoresOrdenador.addAll(atts);
		jogadoresOrdenador.addAll(reserv);
		jogadoresOrdenador.addAll(reserv2);

		return jogadoresOrdenador;
	}

	private List<Player> getPlayers(List<Player> playersTeam, List<Player> jaAdicionados, PositionEnum pos) {
		List<Player> players = new ArrayList<>();
		List<Player> avaliablePlayers = new ArrayList<>();
		avaliablePlayers.addAll(playersTeam);

		int sizePosition = pos.equals(PositionEnum.ATT) ? 2 : 4;

		for (int i = 0; i < sizePosition; i++) {
			avaliablePlayers.removeAll(jaAdicionados);
			
			Player player = avaliablePlayers.get(0);

			for (Player p : avaliablePlayers) {
				if (player.getKick() < p.getKick()) {
					player = p;
				}
			}
			players.add(player);
			jaAdicionados.add(player);
		}

		return players;
	}

	private Player getGoalkeeper(List<Player> jogadores) {
		Player gk = jogadores.get(0);
		for (Player p : jogadores) {
			if (p.getGoalkeaper() > gk.getGoalkeaper()) {
				gk = p;
			}
		}
		return gk;
	}

}
