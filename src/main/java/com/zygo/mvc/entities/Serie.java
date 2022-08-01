package com.zygo.mvc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Serie implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idS;
	@Column
	private Double poidslv1;
	@Column
	private Double poidslv2;
	@Column
	private Double poidslv3;
	@Column
	private Integer rep1;
	@Column
	private Integer rep2;
	@Column
	private Integer rep3;
	@ManyToOne
	private Exercice exercie;
	public Long getIdS() {
		return idS;
	}
	public void setIdS(Long idS) {
		this.idS = idS;
	}
	public Exercice getExercie() {
		return exercie;
	}
	public void setExercie(Exercice exercie) {
		this.exercie = exercie;
	}
	public Double getPoidslv1() {
		return poidslv1;
	}
	public void setPoidslv1(Double poidslv1) {
		this.poidslv1 = poidslv1;
	}
	public Double getPoidslv2() {
		return poidslv2;
	}
	public void setPoidslv2(Double poidslv2) {
		this.poidslv2 = poidslv2;
	}
	public Double getPoidslv3() {
		return poidslv3;
	}
	public void setPoidslv3(Double poidslv3) {
		this.poidslv3 = poidslv3;
	}
	public Integer getRep1() {
		return rep1;
	}
	public void setRep1(Integer rep1) {
		this.rep1 = rep1;
	}
	public Integer getRep2() {
		return rep2;
	}
	public void setRep2(Integer rep2) {
		this.rep2 = rep2;
	}
	public Integer getRep3() {
		return rep3;
	}
	public void setRep3(Integer rep3) {
		this.rep3 = rep3;
	}
	public Double fct() {
		if (rep1!=0 && rep2!=0 && rep3!=0 && poidslv1!=0 && poidslv2!=0 && poidslv3!=0 ) {
		return (rep1*Math.pow(poidslv1, 4.2)+rep2*Math.pow(poidslv2, 4.2)+rep3*Math.pow(poidslv3, 4.2))/3;}
		return null;
	}

}
