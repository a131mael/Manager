package org.aaf.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

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
	
	private LocalDateTime date;
	
	@ManyToOne
	private Player position1;
	private PositionEnum orderP1;
	private int rate1;
	
	@ManyToOne
	private Player position2;
	private PositionEnum orderP2;
	private int rate2;
	
	@ManyToOne
	private Player position3;
	private PositionEnum orderP3;
	private int rate3;
	
	@ManyToOne
	private Player position4;
	private PositionEnum orderP4;
	private int rate4;
	
	@ManyToOne
	private Player position5;
	private PositionEnum orderP5;
	private int rate5;
	
	@ManyToOne
	private Player position6;
	private PositionEnum orderP6;
	private int rate6;
	
	@ManyToOne
	private Player position7;
	private PositionEnum orderP7;
	private int rate7;
	
	@ManyToOne
	private Player position8;
	private PositionEnum orderP8;
	private int rate8;
	
	@ManyToOne
	private Player position9;
	private PositionEnum orderP9;
	private int rate9;
	
	@ManyToOne
	private Player position10;
	private PositionEnum orderP10;
	private int rate10;
	
	@ManyToOne
	private Player position11;
	private PositionEnum orderP11;
	private int rate11;
	
	@ManyToOne
	private Player position12;
	private PositionEnum orderP12;
	private int rate12;
	
	@ManyToOne
	private Player position13;
	private PositionEnum orderP13;
	private int rate13;
	
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
	public int getRate1() {
		return rate1;
	}
	public void setRate1(int rate1) {
		this.rate1 = rate1;
	}
	public int getRate2() {
		return rate2;
	}
	public void setRate2(int rate2) {
		this.rate2 = rate2;
	}
	public int getRate3() {
		return rate3;
	}
	public void setRate3(int rate3) {
		this.rate3 = rate3;
	}
	public int getRate4() {
		return rate4;
	}
	public void setRate4(int rate4) {
		this.rate4 = rate4;
	}
	public int getRate5() {
		return rate5;
	}
	public void setRate5(int rate5) {
		this.rate5 = rate5;
	}
	public int getRate6() {
		return rate6;
	}
	public void setRate6(int rate6) {
		this.rate6 = rate6;
	}
	public int getRate7() {
		return rate7;
	}
	public void setRate7(int rate7) {
		this.rate7 = rate7;
	}
	public int getRate8() {
		return rate8;
	}
	public void setRate8(int rate8) {
		this.rate8 = rate8;
	}
	public int getRate9() {
		return rate9;
	}
	public void setRate9(int rate9) {
		this.rate9 = rate9;
	}
	public int getRate10() {
		return rate10;
	}
	public void setRate10(int rate10) {
		this.rate10 = rate10;
	}
	public int getRate11() {
		return rate11;
	}
	public void setRate11(int rate11) {
		this.rate11 = rate11;
	}
	public int getRate12() {
		return rate12;
	}
	public void setRate12(int rate12) {
		this.rate12 = rate12;
	}
	@ManyToOne
	private Player position14;
	private PositionEnum orderP14;
	private int rate14;
	
	@ManyToOne
	private Player position15;
	private PositionEnum orderP15;
	private int rate15;
	
	@ManyToOne
	private Player position16;
	private PositionEnum orderP16;
	private int rate16;
	
	
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
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public int getRate16() {
		return rate16;
	}
	public void setRate16(int rate16) {
		this.rate16 = rate16;
	}
	public int getRate15() {
		return rate15;
	}
	public void setRate15(int rate15) {
		this.rate15 = rate15;
	}
	public int getRate14() {
		return rate14;
	}
	public void setRate14(int rate14) {
		this.rate14 = rate14;
	}
	public int getRate13() {
		return rate13;
	}
	public void setRate13(int rate13) {
		this.rate13 = rate13;
	}
	
}