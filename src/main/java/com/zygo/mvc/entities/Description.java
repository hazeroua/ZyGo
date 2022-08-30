//package com.zygo.mvc.entities;
//
//import java.io.Serializable;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//@Entity
//public class Description implements Serializable{
//	@Id @GeneratedValue(strategy = GenerationType.AUTO)
//	private String Description;
//	@ManyToOne
//	private Exercice exercice;
//	@ManyToOne
//	private Programme programme;
//	public String getDescription() {
//		return Description;
//	}
//	public void setDescription(String description) {
//		Description = description;
//	}
//	public Exercice getExercice() {
//		return exercice;
//	}
//	public void setExercice(Exercice exercice) {
//		this.exercice = exercice;
//	}
//	public Programme getProgramme() {
//		return programme;
//	}
//	public void setProgramme(Programme programme) {
//		this.programme = programme;
//	}
//	
//	
//}
