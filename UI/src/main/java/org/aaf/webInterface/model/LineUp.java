package org.aaf.webInterface.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.aaf.webInterface.util.PositionEnum;

@Entity
public class LineUp {

	@Id
	@GeneratedValue(generator = "GENERATE_LineUp", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "GENERATE_LineUp", sequenceName = "LineUp_pk_seq", allocationSize = 1)
	private Long id;
	
	@ManyToOne
	private Team team;
	
	@OneToOne
	private Match match;
	
	@ManyToOne
	private Player position1;
	private PositionEnum orderP1;
	
	@ManyToOne
	private Player position2;
	private PositionEnum orderP2;

	@ManyToOne
	private Player position3;
	private PositionEnum orderP3;

	@ManyToOne
	private Player position4;
	private PositionEnum orderP4;

	@ManyToOne
	private Player position5;
	private PositionEnum orderP5;

	@ManyToOne
	private Player position6;
	private PositionEnum orderP6;

	@ManyToOne
	private Player position7;
	private PositionEnum orderP7;

	@ManyToOne
	private Player position8;
	private PositionEnum orderP8;

	@ManyToOne
	private Player position9;
	private PositionEnum orderP9;

	@ManyToOne
	private Player position10;
	private PositionEnum orderP10;

	@ManyToOne
	private Player position11;
	private PositionEnum orderP11;

	@ManyToOne
	private Player position12;
	private PositionEnum orderP12;

	@ManyToOne
	private Player position13;
	private PositionEnum orderP13;

	@ManyToOne
	private Player position14;
	private PositionEnum orderP14;

	@ManyToOne
	private Player position15;
	private PositionEnum orderP15;

	@ManyToOne
	private Player position16;
	private PositionEnum orderP16;
	
	
	public Player getPosition1() {
		return position1;
	}
	public void setPosition1(Player position1) {
		this.position1 = position1;
	}
	public PositionEnum getOrderP1() {
		return orderP1;
	}
	public void setOrderP1(PositionEnum orderP1) {
		this.orderP1 = orderP1;
	}
	public Player getPosition2() {
		return position2;
	}
	public void setPosition2(Player position2) {
		this.position2 = position2;
	}
	public PositionEnum getOrderP2() {
		return orderP2;
	}
	public void setOrderP2(PositionEnum orderP2) {
		this.orderP2 = orderP2;
	}
	public Player getPosition3() {
		return position3;
	}
	public void setPosition3(Player position3) {
		this.position3 = position3;
	}
	public PositionEnum getOrderP3() {
		return orderP3;
	}
	public void setOrderP3(PositionEnum orderP3) {
		this.orderP3 = orderP3;
	}
	public Player getPosition5() {
		return position5;
	}
	public void setPosition5(Player position5) {
		this.position5 = position5;
	}
	public PositionEnum getOrderP4() {
		return orderP4;
	}
	public void setOrderP4(PositionEnum orderP4) {
		this.orderP4 = orderP4;
	}
	public Player getPosition6() {
		return position6;
	}
	public void setPosition6(Player position6) {
		this.position6 = position6;
	}
	public PositionEnum getOrderP5() {
		return orderP5;
	}
	public void setOrderP5(PositionEnum orderP5) {
		this.orderP5 = orderP5;
	}
	public Player getPosition7() {
		return position7;
	}
	public void setPosition7(Player position7) {
		this.position7 = position7;
	}
	public PositionEnum getOrderP6() {
		return orderP6;
	}
	public void setOrderP6(PositionEnum orderP6) {
		this.orderP6 = orderP6;
	}
	public Player getPosition8() {
		return position8;
	}
	public void setPosition8(Player position8) {
		this.position8 = position8;
	}
	public PositionEnum getOrderP7() {
		return orderP7;
	}
	public void setOrderP7(PositionEnum orderP7) {
		this.orderP7 = orderP7;
	}
	public Player getPosition9() {
		return position9;
	}
	public void setPosition9(Player position9) {
		this.position9 = position9;
	}
	public PositionEnum getOrderP8() {
		return orderP8;
	}
	public void setOrderP8(PositionEnum orderP8) {
		this.orderP8 = orderP8;
	}
	public Player getPosition10() {
		return position10;
	}
	public void setPosition10(Player position10) {
		this.position10 = position10;
	}
	public PositionEnum getOrderP9() {
		return orderP9;
	}
	public void setOrderP9(PositionEnum orderP9) {
		this.orderP9 = orderP9;
	}
	public Player getPosition11() {
		return position11;
	}
	public void setPosition11(Player position11) {
		this.position11 = position11;
	}
	public PositionEnum getOrderP10() {
		return orderP10;
	}
	public void setOrderP10(PositionEnum orderP10) {
		this.orderP10 = orderP10;
	}
	public Player getPosition12() {
		return position12;
	}
	public void setPosition12(Player position12) {
		this.position12 = position12;
	}
	public PositionEnum getOrderP11() {
		return orderP11;
	}
	public void setOrderP11(PositionEnum orderP11) {
		this.orderP11 = orderP11;
	}
	public Player getPosition13() {
		return position13;
	}
	public void setPosition13(Player position13) {
		this.position13 = position13;
	}
	public PositionEnum getOrderP12() {
		return orderP12;
	}
	public void setOrderP12(PositionEnum orderP12) {
		this.orderP12 = orderP12;
	}
	public PositionEnum getOrderP13() {
		return orderP13;
	}
	public void setOrderP13(PositionEnum orderP13) {
		this.orderP13 = orderP13;
	}
	public Player getPosition14() {
		return position14;
	}
	public void setPosition14(Player position14) {
		this.position14 = position14;
	}
	public PositionEnum getOrderP14() {
		return orderP14;
	}
	public void setOrderP14(PositionEnum orderP14) {
		this.orderP14 = orderP14;
	}
	public Player getPosition15() {
		return position15;
	}
	public void setPosition15(Player position15) {
		this.position15 = position15;
	}
	public PositionEnum getOrderP15() {
		return orderP15;
	}
	public void setOrderP15(PositionEnum orderP15) {
		this.orderP15 = orderP15;
	}
	public Player getPosition16() {
		return position16;
	}
	public void setPosition16(Player position16) {
		this.position16 = position16;
	}
	public PositionEnum getOrderP16() {
		return orderP16;
	}
	public void setOrderP16(PositionEnum orderP16) {
		this.orderP16 = orderP16;
	}
	public Player getPosition4() {
		return position4;
	}
	public void setPosition4(Player position4) {
		this.position4 = position4;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public Match getMatch() {
		return match;
	}
	public void setMatch(Match match) {
		this.match = match;
	}
	
}