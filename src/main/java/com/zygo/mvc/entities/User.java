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
	@JoinTable(name="USERS_EXERCICES")
	private List<Exercice> exercices= new ArrayList<>();

	public String getPassword() {
		return password;
	}
	public void SetExerciceForaUser(Exercice e) {
		exercices.add(e);
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

}
