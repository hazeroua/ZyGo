package com.zygo.mvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class Music {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idM;
	private String MusicName;
	private String URL;
	@OneToOne
	private User user;
	public String getMusicName() {
		return MusicName;
	}
	public void setMusicName(String musicName) {
		MusicName = musicName;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
