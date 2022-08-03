package com.zygo.mvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zygo.mvc.entities.LegsExercice;

public interface LegsExerciceRepository extends JpaRepository<LegsExercice, Long> {
	LegsExercice findByIdELe(Long idEle);
}
