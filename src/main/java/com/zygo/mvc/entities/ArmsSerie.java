package com.zygo.mvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class ArmsSerie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSA;
	@Column
	private Double poidslv1A;
	@Column
	private Double poidslv2A;
	@Column
	private Double poidslv3A;
	@Column
	private Integer rep1A;
	@Column
	private Integer rep2A;
	@Column
	private Integer rep3A;
	@ManyToOne
	private ArmsExercice exercieA;
	public Long getIdSA() {
		return idSA;
	}
	public void setIdSA(Long idSA) {
		this.idSA = idSA;
	}
	public Double getPoidslv1A() {
		return poidslv1A;
	}
	public void setPoidslv1A(Double poidslv1a) {
		poidslv1A = poidslv1a;
	}
	public Double getPoidslv2A() {
		return poidslv2A;
	}
	public void setPoidslv2A(Double poidslv2a) {
		poidslv2A = poidslv2a;
	}
	public Double getPoidslv3A() {
		return poidslv3A;
	}
	public void setPoidslv3A(Double poidslv3a) {
		poidslv3A = poidslv3a;
	}
	public Integer getRep1A() {
		return rep1A;
	}
	public void setRep1A(Integer rep1a) {
		rep1A = rep1a;
	}
	public Integer getRep2A() {
		return rep2A;
	}
	public void setRep2A(Integer rep2a) {
		rep2A = rep2a;
	}
	public Integer getRep3A() {
		return rep3A;
	}
	public void setRep3A(Integer rep3a) {
		rep3A = rep3a;
	}
	public ArmsExercice getExercieA() {
		return exercieA;
	}
	public void setExercieA(ArmsExercice exercieA) {
		this.exercieA = exercieA;
	}
	public Double fct() {
		if (rep1A!=0 && rep2A!=0 && rep3A!=0 && poidslv1A!=0 && poidslv2A!=0 && poidslv3A!=0 ) {
		return (rep1A*Math.pow(poidslv1A, 4.2)+rep2A*Math.pow(poidslv2A, 4.2)+rep3A*Math.pow(poidslv3A, 4.2))/3;}
		return null;
	}
	
}
