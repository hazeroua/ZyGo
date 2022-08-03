package com.zygo.mvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zygo.mvc.entities.ArmsExercice;

public interface ArmsExerciceRepository extends JpaRepository<ArmsExercice, Long> {
	ArmsExercice findByIdEA(Long idea);
}
