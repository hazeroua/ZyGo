package com.zygo.mvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zygo.mvc.entities.Serie;


public interface SerieRepository extends JpaRepository<Serie, Long> {
	Serie findByIdS(Long id);
}
