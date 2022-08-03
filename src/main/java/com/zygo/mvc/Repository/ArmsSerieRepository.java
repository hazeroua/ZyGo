package com.zygo.mvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zygo.mvc.entities.ArmsSerie;

public interface ArmsSerieRepository extends JpaRepository<ArmsSerie, Long> {
	ArmsSerie findByIdSA(Long idsa);
}
