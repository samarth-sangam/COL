package com.comviva.col.dao;

import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comviva.col.dao.interfaces.IActivationReportDao;
import com.comviva.col.entity.ActivationReport;
import com.comviva.col.repository.ActivationReportRepository;

/**
 * ActivationReport Dao Implementations.
 * 
 * @author samarth.sangam, mahendra.prajapati
 *
 */
@Component
public class ActivationReportDaoImpl extends AbstractDaoImpl<ActivationReport> implements IActivationReportDao {

	@Autowired
	private ActivationReportRepository activationReportRepository;

	private Logger log = Logger.getLogger(ActivationReportDaoImpl.class);

	private static final String TABLE_NAME = "COL_ACTIVATION_REPORT";

	@Override
	public List<ActivationReport> addAllActivationReport(List<ActivationReport> list) {
		return activationReportRepository.saveAll(list);

	}

	@Override
	public List<ActivationReport> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String id) {
		return super.viewByFromAndToDate(fromDate, toDate, id, TABLE_NAME);
	}
}
