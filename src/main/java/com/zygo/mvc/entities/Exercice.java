package com.zygo.mvc.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Exercice implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idE;
	@OneToMany
	@JoinTable(name="SERIES_EXERCICES")
	private List<Serie> series;
	private String nameE;
	@ManyToOne
	private User user;
//	@OneToMany
//	private List<Description> Description ;
	@ManyToOne
	private Programme programmes;


//	public List<Programme> getProgrammes() {
//		return programmes;
//	}
//	public void setProgrammeForAnExercice(Programme p) {
//		programmes.add(p);
//	}
//	public void setProgrammes(List<Programme> programmes) {
//		this.programmes = programmes;
//	}

	
//	public List<Description> getDescription() {
//		return Description;
//	}
//
//	public void setDescription(List<Description> description) {
//		Description = description;
//	}

	public Long getIdE() {
		return idE;
	}
	
	public Programme getProgrammes() {
		return programmes;
	}

	public void setProgrammes(Programme programmes) {
		this.programmes = programmes;
	}

	public String getNameE() {
		return nameE;
	}

	public void setNameE(String nameE) {
		this.nameE = nameE;
	}

	public void setIdE(Long idE) {
		this.idE = idE;
	}
	public List<Serie> getSeries() {
		return series;
	}
	public void setSeries(List<Serie> series) {
		this.series = series;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
