package com.zygo.mvc.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zygo.mvc.entities.Programme;

public interface ProgrammeRepository extends JpaRepository<Programme, Long> {
	Programme findByIdPr(Long id);
}
