package com.comviva.col.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
	public ActivationReport addActivationReport(ActivationReport activationReport) throws Exception {
		if (exists(activationReport.getTrId())) {
			Exception exception = new Exception("Transaction with " + activationReport.getTrId() + " exists.");
			log.error("Exception occured", exception);
			throw exception;
		}
		log.info("Activation report added.");
		return activationReportRepository.save(activationReport);

	}

	@Override
	public ActivationReport viewActivationReport(int id) {
		Optional<ActivationReport> activationReport = activationReportRepository.findById(id);
		if (activationReport.isPresent()) {
			log.info("Activation report found by id = " + id);
			return activationReport.get();
		}
		log.error("Activation report not found by id = " + id);
		return null;
	}

	@Override
	public ActivationReport updateActivationReport(ActivationReport activationReport) throws Exception {
		if (exists(activationReport.getTrId())) {
			log.info("Activation report updated");
			return activationReportRepository.save(activationReport);
		}
		Exception exception = new Exception("Activation Report Doesnot exists.");
		log.error("Exception occured");
		throw exception;
	}

	@Override
	public boolean deleteActivationReport(int id) {
		if (exists(id)) {
			activationReportRepository.deleteById(id);
			log.info("Activation Report deleted by id = " + id);
			return true;
		}
		log.error("Activation report not found by id = " + id);
		return false;
	}

	private boolean exists(int id) {
		log.info("checking for the id = " + id);
		return activationReportRepository.existsById(id);
	}

	@Override
	public List<ActivationReport> addAllActivationReport(List<ActivationReport> list) {
		return activationReportRepository.saveAll(list);

	}

	@Override
	public List<ActivationReport> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String id) {
		return super.viewByFromAndToDate(fromDate, toDate, id, TABLE_NAME);
	}

	@Override
	public List<ActivationReport> viewByMonth(String month, String id) {
		return super.viewByMonth(month, id, TABLE_NAME);
	}

	@Override
	public void deleteByMonth(String month, String id) {
		super.deleteByMonth(month, id, TABLE_NAME);

	}
}
