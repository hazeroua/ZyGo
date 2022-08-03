package com.zygo.mvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zygo.mvc.entities.LegsSerie;

public interface LegsSerieRepository extends JpaRepository<LegsSerie, Long> {
	LegsSerie findByIdSLe(Long idsle);
}
