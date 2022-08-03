package com.zygo.mvc.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class LatsExercice implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEL;
	@OneToMany
	@JoinTable(name="SERIES_EXERCICES_LATS")
	private List<LatsSerie> seriesL;
	private String nameEL;
	@ManyToOne
	private User user;
	public Long getIdEL() {
		return idEL;
	}
	public void setIdEL(Long idEL) {
		this.idEL = idEL;
	}
	public List<LatsSerie> getSeriesL() {
		return seriesL;
	}
	public void setSeriesL(List<LatsSerie> seriesL) {
		this.seriesL = seriesL;
	}
	public String getNameEL() {
		return nameEL;
	}
	public void setNameEL(String nameEL) {
		this.nameEL = nameEL;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
