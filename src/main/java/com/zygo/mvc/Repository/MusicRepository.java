package com.zygo.mvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zygo.mvc.entities.Music;

public interface MusicRepository extends JpaRepository<Music, Long>{
	Music findByIdM(Long idM);
}
