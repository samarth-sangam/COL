package com.comviva.col.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.comviva.col.dao.interfaces.IActivationReportDao;
import com.comviva.col.entity.ActivationReport;
import com.comviva.col.entity.id.ActivationReportId;

/**
 * ActivationReport Dao Implementations.
 * 
 * @author samarth.sangam, mahendra.prajapati
 * @deprecated
 *
 */
@Deprecated
@Repository
@Transactional
public class ActivationReportDaoImpl extends AbstractDaoImpl<ActivationReport, ActivationReportId>
		implements IActivationReportDao {

	private Logger log = Logger.getLogger(ActivationReportDaoImpl.class);

	private static final String TABLE_NAME = "COL_ACTIVATION_REPORT";

	@Override
	public List<ActivationReport> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String id)
			throws Exception {

		try {
			return super.viewByFromAndToDate(fromDate, toDate, id, TABLE_NAME);
		} catch (NoResultException e) {
			return new ArrayList<>();
		}
	}

	@Override
	public int addAllActivationReport(List<ActivationReport> list) {
		log.info("saving list of ActivationReport");
		return this.saveInBatch(list);

	}

}
