package com.zygo.mvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zygo.mvc.entities.LatsSerie;

public interface LatsSerieRepository extends JpaRepository<LatsSerie, Long> {
	LatsSerie findByIdSL(Long idsL);
}
