package com.zygo.mvc.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User implements Serializable {
	  @Id
	  @Column(unique=true)
	private String username;
	private String password;
	@ManyToMany
	@JoinTable(name="USERS_ROLES")
	private Collection<Role> roles;
	@OneToMany
	@JoinTable(name="USERS_EXERCICES_PECTORALS")
	private List<Exercice> exercices= new ArrayList<>();
	@OneToMany
	@JoinTable(name="USERS_EXERCICES_LATS")
	private List<LatsExercice> exercicesL= new ArrayList<>();
	@OneToMany
	@JoinTable(name="USERS_EXERCICES_LEGS")
	private List<LegsExercice> exercicesLe= new ArrayList<>();
	@OneToMany
	@JoinTable(name="USERS_EXERCICES_ARMS")
	private List<ArmsExercice> exercicesA= new ArrayList<>();
	@OneToMany
	@JoinTable(name="USERS_EXERCICES_SHOULDERS")
	private List<ShouldersExercice> exercicesS= new ArrayList<>();
	@OneToMany
	@JoinTable(name="USERS_MUSIC")
	private List<Music> Musics = new ArrayList<>();
	@OneToMany
	@JoinTable(name="USERS_PROGRAMME_PECTORALS")
	private List<Programme> programmes= new ArrayList<Programme>();
	public List<LegsExercice> getExercicesLe() {
		return exercicesLe;
	}
	public void setExercicesLe(List<LegsExercice> exercicesLe) {
		this.exercicesLe = exercicesLe;
	}
	public List<ArmsExercice> getExercicesA() {
		return exercicesA;
	}
	public void setExercicesA(List<ArmsExercice> exercicesA) {
		this.exercicesA = exercicesA;
	}
	public List<ShouldersExercice> getExercicesS() {
		return exercicesS;
	}
	public void setExercicesS(List<ShouldersExercice> exercicesS) {
		this.exercicesS = exercicesS;
	}
	public List<LatsExercice> getExercicesL() {
		return exercicesL;
	}
	public void setExercicesL(List<LatsExercice> exercicesL) {
		this.exercicesL = exercicesL;
	}
	public String getPassword() {
		return password;
	}
	public void SetExerciceForaUser(Exercice e) {
		exercices.add(e);
	}
	public void SetExerciceLForaUser(LatsExercice e) {
		exercicesL.add(e);
	}
	public void SetExerciceSForaUser(ShouldersExercice e) {
		exercicesS.add(e);
	}
	public void SetExerciceLeForaUser(LegsExercice e) {
		exercicesLe.add(e);
	}
	public void SetExerciceAForaUser(ArmsExercice e) {
		exercicesA.add(e);
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	public User(String username, String password) {
		super();
		this.username=username;
		this.password = password;
	}
	public List<Exercice> getExercices() {
		return exercices;
	}
	public void setExercices(List<Exercice> exercices) {
		this.exercices = exercices;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setProgrammeForaUser(Programme p) {
		programmes.add(p);
	}
	public List<Music> getMusics() {
		return Musics;
	}
	public void setMusics(List<Music> musics) {
		Musics = musics;
	}
	public List<Programme> getProgrammes() {
		return programmes;
	}
	public void setProgrammes(List<Programme> programmes) {
		this.programmes = programmes;
	}
	
}
