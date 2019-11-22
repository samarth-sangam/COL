package com.comviva.col.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comviva.col.entity.ActivationReport;
import com.comviva.col.entity.id.ActivationReportId;

/**
 * 
 * @author samarth.sangam
 *
 */
public interface ActivationReportRepository extends JpaRepository<ActivationReport, ActivationReportId> {

}
