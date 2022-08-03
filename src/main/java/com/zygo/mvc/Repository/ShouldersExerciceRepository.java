package com.zygo.mvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zygo.mvc.entities.ShouldersExercice;

public interface ShouldersExerciceRepository extends JpaRepository<ShouldersExercice, Long> {
	ShouldersExercice findByIdES(Long ideS);
}
