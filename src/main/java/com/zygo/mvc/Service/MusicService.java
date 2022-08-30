package com.zygo.mvc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zygo.mvc.Repository.MusicRepository;
import com.zygo.mvc.entities.Music;

@Service
public class MusicService {
	@Autowired
	private MusicRepository repository;
	
	public Music findByIdM(Long idM) {
		return repository.findByIdM(idM);
	}
	public List<Music> getAllMusic(){
		return repository.findAll();
	}
}
