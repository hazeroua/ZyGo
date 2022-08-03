package com.zygo.mvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zygo.mvc.entities.LatsExercice;

public interface LatsExerciceRepository extends JpaRepository<LatsExercice, Long> {
	LatsExercice findByIdEL(Long idEL);
}
