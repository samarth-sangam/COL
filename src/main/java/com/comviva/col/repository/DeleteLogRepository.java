package com.comviva.col.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comviva.col.entity.DeleteLog;

public interface DeleteLogRepository extends JpaRepository<DeleteLog, Integer> {

}
