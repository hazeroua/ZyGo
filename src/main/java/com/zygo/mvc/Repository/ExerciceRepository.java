package com.zygo.mvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zygo.mvc.entities.Exercice;



public interface ExerciceRepository extends JpaRepository<Exercice, Long> {
	Exercice findByIdE(Long idE);
}
