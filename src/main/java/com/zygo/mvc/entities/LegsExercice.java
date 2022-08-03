package com.zygo.mvc.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class LegsExercice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idELe;
	@OneToMany
	@JoinTable(name="SERIES_EXERCICES_LEGS")
	private List<LegsSerie> seriesLe;
	private String nameELe;
	@ManyToOne
	private User user;
	public Long getIdELe() {
		return idELe;
	}
	public void setIdELe(Long idELe) {
		this.idELe = idELe;
	}
	public List<LegsSerie> getSeriesLe() {
		return seriesLe;
	}
	public void setSeriesLe(List<LegsSerie> seriesLe) {
		this.seriesLe = seriesLe;
	}
	public String getNameELe() {
		return nameELe;
	}
	public void setNameELe(String nameELe) {
		this.nameELe = nameELe;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
