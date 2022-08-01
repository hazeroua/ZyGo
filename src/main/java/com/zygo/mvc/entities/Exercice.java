package com.zygo.mvc.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
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
	public Long getIdE() {
		return idE;
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
