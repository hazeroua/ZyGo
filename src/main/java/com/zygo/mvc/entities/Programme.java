package com.zygo.mvc.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Programmes")
public class Programme implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPr;
	private String Description;
	private String nomPr;
	@ManyToOne
	private User user;
	private int nombreExercice;
	@OneToMany
	private List<Exercice> exercices;

	public List<Exercice> getExercices() {
		return exercices;
	}
	public void setAnExerciceForAProgramme(Exercice e) {
		
		exercices.add(e);
	}
	public void setExercices(List<Exercice> exercices) {
		this.exercices = exercices;
	}
	public String getNomPr() {
		return nomPr;
	}
	public void setNomPr(String nomPr) {
		this.nomPr = nomPr;
	}
	public int getNombreExercice() {
		return nombreExercice;
	}
	public void setNombreExercice(int nombreExercice) {
		this.nombreExercice = nombreExercice;
	}

	public Long getIdPr() {
		return idPr;
	}
	public void setIdPr(Long idPr) {
		this.idPr = idPr;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}






