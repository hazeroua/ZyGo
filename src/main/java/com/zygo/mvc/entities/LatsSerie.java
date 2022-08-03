package com.zygo.mvc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LatsSerie implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSL;
	@Column
	private Double poidslv1L;
	@Column
	private Double poidslv2L;
	@Column
	private Double poidslv3L;
	@Column
	private Integer rep1L;
	@Column
	private Integer rep2L;
	@Column
	private Integer rep3L;
	@ManyToOne
	private LatsExercice exercieL;
	public Long getIdSL() {
		return idSL;
	}
	public void setIdSL(Long idSL) {
		this.idSL = idSL;
	}
	public Double getPoidslv1L() {
		return poidslv1L;
	}
	public void setPoidslv1L(Double poidslv1l) {
		poidslv1L = poidslv1l;
	}
	public Double getPoidslv2L() {
		return poidslv2L;
	}
	public void setPoidslv2L(Double poidslv2l) {
		poidslv2L = poidslv2l;
	}
	public Double getPoidslv3L() {
		return poidslv3L;
	}
	public void setPoidslv3L(Double poidslv3l) {
		poidslv3L = poidslv3l;
	}
	public Integer getRep1L() {
		return rep1L;
	}
	public void setRep1L(Integer rep1l) {
		rep1L = rep1l;
	}
	public Integer getRep2L() {
		return rep2L;
	}
	public void setRep2L(Integer rep2l) {
		rep2L = rep2l;
	}
	public Integer getRep3L() {
		return rep3L;
	}
	public void setRep3L(Integer rep3l) {
		rep3L = rep3l;
	}
	public LatsExercice getExercie() {
		return exercieL;
	}
	public void setExercie(LatsExercice exercie) {
		this.exercieL = exercie;
	}
	public Double fct() {
		if (rep1L!=0 && rep2L!=0 && rep3L!=0 && poidslv1L!=0 && poidslv2L!=0 && poidslv3L!=0 ) {
		return (rep1L*Math.pow(poidslv1L, 4.2)+rep2L*Math.pow(poidslv2L, 4.2)+rep3L*Math.pow(poidslv3L, 4.2))/3;}
		return null;
	}
}
