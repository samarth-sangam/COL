package com.comviva.col.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comviva.col.dao.interfaces.IActivationReportDao;
import com.comviva.col.entity.ActivationReport;
import com.comviva.col.repository.ActivationReportRepository;

/**
 * ActivationReport Dao Implementations.
 * 
 * @author samarth.sangam
 *
 */
@Component
public class ActivationReportDaoImpl extends AbstractDaoImpl<ActivationReport> implements IActivationReportDao {

	@Autowired
	private ActivationReportRepository activationReportRepository;

	private static final String TABLE_NAME = "COL_ACTIVATION_REPORT";

	@Override
	public void addActivationReport(ActivationReport activationReport) throws Exception {
		if (exists(activationReport.getTrId())) {
			throw new Exception("Transaction with " + activationReport.getTrId() + " exists.");
		}
		activationReportRepository.save(activationReport);

	}

	@Override
	public ActivationReport viewActivationReport(int id) {
		Optional<ActivationReport> activationReport = activationReportRepository.findById(id);
		if (activationReport.isPresent()) {
			return activationReport.get();
		}
		return null;
	}

	@Override
	public void updateActivationReport(ActivationReport activationReport) throws Exception {
		if (exists(activationReport.getTrId())) {
			activationReportRepository.save(activationReport);
			return;
		}
		throw new Exception("Activation Report Doesnot exists!");
	}

	@Override
	public boolean deleteActivationReport(int id) {
		if (exists(id)) {
			activationReportRepository.deleteById(id);
			return true;
		}
		return false;
	}

	private boolean exists(int id) {
		return activationReportRepository.existsById(id);
	}

	@Override
	public void addAllActivationReport(List<ActivationReport> list) {
		activationReportRepository.saveAll(list);

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
