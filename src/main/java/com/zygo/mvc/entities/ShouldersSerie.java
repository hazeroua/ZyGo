package com.zygo.mvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class ShouldersSerie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSS;
	@Column
	private Double poidslv1S;
	@Column
	private Double poidslv2S;
	@Column
	private Double poidslv3S;
	@Column
	private Integer rep1S;
	@Column
	private Integer rep2S;
	@Column
	private Integer rep3S;
	@ManyToOne
	private ShouldersExercice exercieS;
	public Long getIdSS() {
		return idSS;
	}
	public void setIdSS(Long idSS) {
		this.idSS = idSS;
	}
	public Double getPoidslv1S() {
		return poidslv1S;
	}
	public void setPoidslv1S(Double poidslv1s) {
		poidslv1S = poidslv1s;
	}
	public Double getPoidslv2S() {
		return poidslv2S;
	}
	public void setPoidslv2S(Double poidslv2s) {
		poidslv2S = poidslv2s;
	}
	public Double getPoidslv3S() {
		return poidslv3S;
	}
	public void setPoidslv3S(Double poidslv3s) {
		poidslv3S = poidslv3s;
	}
	public Integer getRep1S() {
		return rep1S;
	}
	public void setRep1S(Integer rep1s) {
		rep1S = rep1s;
	}
	public Integer getRep2S() {
		return rep2S;
	}
	public void setRep2S(Integer rep2s) {
		rep2S = rep2s;
	}
	public Integer getRep3S() {
		return rep3S;
	}
	public void setRep3S(Integer rep3s) {
		rep3S = rep3s;
	}
	public ShouldersExercice getExercieS() {
		return exercieS;
	}
	public void setExercieS(ShouldersExercice exercieS) {
		this.exercieS = exercieS;
	}
	public Double fct() {
		if (rep1S!=0 && rep2S!=0 && rep3S!=0 && poidslv1S!=0 && poidslv2S!=0 && poidslv3S!=0 ) {
		return (rep1S*Math.pow(poidslv1S, 4.2)+rep2S*Math.pow(poidslv2S, 4.2)+rep3S*Math.pow(poidslv3S, 4.2))/3;}
		return null;
	}
}
