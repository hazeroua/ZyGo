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
public class ShouldersExercice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idES;
	@OneToMany
	@JoinTable(name="SERIES_EXERCICES_SHOULDERS")
	private List<ShouldersSerie> seriesS;
	private String nameES;
	@ManyToOne
	private User user;
	public Long getIdES() {
		return idES;
	}
	public void setIdES(Long idES) {
		this.idES = idES;
	}
	public List<ShouldersSerie> getSeriesS() {
		return seriesS;
	}
	public void setSeriesS(List<ShouldersSerie> seriesS) {
		this.seriesS = seriesS;
	}
	public String getNameES() {
		return nameES;
	}
	public void setNameES(String nameES) {
		this.nameES = nameES;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
