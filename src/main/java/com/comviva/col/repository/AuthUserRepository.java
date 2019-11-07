package com.comviva.col.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comviva.col.entity.AuthUser;

public interface AuthUserRepository extends JpaRepository<AuthUser, Integer> {
	AuthUser findByUsername(String username);
}
