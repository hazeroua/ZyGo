package com.zygo.mvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zygo.mvc.entities.Role;



public interface RoleRepository extends JpaRepository<Role, String> {

}
