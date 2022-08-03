package com.zygo.mvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zygo.mvc.entities.ShouldersSerie;

public interface ShouldersSerieRepository extends JpaRepository<ShouldersSerie, Long> {
	ShouldersSerie findByIdSS(Long idsS);
}
