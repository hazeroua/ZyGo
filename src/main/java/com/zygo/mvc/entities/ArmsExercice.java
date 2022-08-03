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
public class ArmsExercice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEA;
	@OneToMany
	@JoinTable(name="SERIES_EXERCICES_ARMS")
	private List<ArmsSerie> seriesA;
	private String nameEA;
	@ManyToOne
	private User user;
	public Long getIdEA() {
		return idEA;
	}
	public void setIdEA(Long idEA) {
		this.idEA = idEA;
	}
	public List<ArmsSerie> getSeriesA() {
		return seriesA;
	}
	public void setSeriesA(List<ArmsSerie> seriesA) {
		this.seriesA = seriesA;
	}
	public String getNameEA() {
		return nameEA;
	}
	public void setNameEA(String nameEA) {
		this.nameEA = nameEA;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
