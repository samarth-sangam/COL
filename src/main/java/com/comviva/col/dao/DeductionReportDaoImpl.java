package com.comviva.col.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comviva.col.dao.interfaces.IDeductionReportDao;
import com.comviva.col.entity.DeductionReport;
import com.comviva.col.repository.DeductionReportRepository;

/**
 * DeductionReport Dao implementations.
 * 
 * @author samarth.sangam
 *
 */
@Component
public class DeductionReportDaoImpl extends AbstractDaoImpl<DeductionReport> implements IDeductionReportDao {

	private static final String TABLE_NAME = "COL_DEDUCTION_REPORT";
	@Autowired
	private DeductionReportRepository deductionReportRepository;

	@Override
	public void addAllActivationReport(List<DeductionReport> list) {
		deductionReportRepository.saveAll(list);

	}

	@Override
	public void addActivationReport(DeductionReport deductionReport) throws Exception {
		if (exists(deductionReport.getTrId())) {
			throw new Exception("Transaction with " + deductionReport.getTrId() + " exists.");
		}
		deductionReportRepository.save(deductionReport);

	}

	@Override
	public DeductionReport viewDeductionReport(int id) {
		Optional<DeductionReport> deductionReport = deductionReportRepository.findById(id);
		if (deductionReport.isPresent()) {
			return deductionReport.get();
		}
		return null;
	}

	@Override
	public void updateDeductionReport(DeductionReport deductionReport) throws Exception {
		if (exists(deductionReport.getTrId())) {
			deductionReportRepository.save(deductionReport);
		}
		throw new Exception("Deduction Report is Not Found");

	}

	@Override
	public boolean deleteDeductionReport(int id) {
		if (exists(id)) {
			deductionReportRepository.deleteById(id);
			return true;
		}
		return false;
	}

	private boolean exists(int id) {
		return deductionReportRepository.existsById(id);
	}

	@Override
	public List<DeductionReport> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String externalId) {
		return super.viewByFromAndToDate(fromDate, toDate, externalId, TABLE_NAME);
	}

	@Override
	public List<DeductionReport> viewByMonth(String month, String id) {
		return super.viewByMonth(month, id, TABLE_NAME);
	}

	@Override
	public void deleteByMonth(String month, String id) {
		super.deleteByMonth(month, id, TABLE_NAME);

	}

}
