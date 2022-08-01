package com.zygo.mvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zygo.mvc.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String Username);
}
