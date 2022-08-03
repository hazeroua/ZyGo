package com.zygo.mvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LegsSerie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSLe;
	@Column
	private Double poidslv1Le;
	@Column
	private Double poidslv2Le;
	@Column
	private Double poidslv3Le;
	@Column
	private Integer rep1Le;
	@Column
	private Integer rep2Le;
	@Column
	private Integer rep3Le;
	@ManyToOne
	private LegsExercice exercieLe;
	public Long getIdSLe() {
		return idSLe;
	}
	public void setIdSLe(Long idSLe) {
		this.idSLe = idSLe;
	}
	public Double getPoidslv1Le() {
		return poidslv1Le;
	}
	public void setPoidslv1Le(Double poidslv1Le) {
		this.poidslv1Le = poidslv1Le;
	}
	public Double getPoidslv2Le() {
		return poidslv2Le;
	}
	public void setPoidslv2Le(Double poidslv2Le) {
		this.poidslv2Le = poidslv2Le;
	}
	public Double getPoidslv3Le() {
		return poidslv3Le;
	}
	public void setPoidslv3Le(Double poidslv3Le) {
		this.poidslv3Le = poidslv3Le;
	}
	public Integer getRep1Le() {
		return rep1Le;
	}
	public void setRep1Le(Integer rep1Le) {
		this.rep1Le = rep1Le;
	}
	public Integer getRep2Le() {
		return rep2Le;
	}
	public void setRep2Le(Integer rep2Le) {
		this.rep2Le = rep2Le;
	}
	public Integer getRep3Le() {
		return rep3Le;
	}
	public void setRep3Le(Integer rep3Le) {
		this.rep3Le = rep3Le;
	}
	public LegsExercice getExercieLe() {
		return exercieLe;
	}
	public void setExercieLe(LegsExercice exercieLe) {
		this.exercieLe = exercieLe;
	}
	public Double fct() {
		if (rep1Le!=0 && rep2Le!=0 && rep3Le!=0 && poidslv1Le!=0 && poidslv2Le!=0 && poidslv3Le!=0 ) {
		return (rep1Le*Math.pow(poidslv1Le, 4.2)+rep2Le*Math.pow(poidslv2Le, 4.2)+rep3Le*Math.pow(poidslv3Le, 4.2))/3;}
		return null;
	}
}
