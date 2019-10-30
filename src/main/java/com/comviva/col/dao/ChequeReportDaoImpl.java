package com.comviva.col.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comviva.col.dao.interfaces.IChequeReportDao;
import com.comviva.col.entity.ChequeReport;
import com.comviva.col.repository.ChequeReportRepository;

/**
 * ChequeReport Dao implementation.
 * 
 * @author samarth.sangam
 *
 */
@Component
public class ChequeReportDaoImpl implements IChequeReportDao {

	@Autowired
	private ChequeReportRepository chequeReportRepository;

	@Override
	public void addAllChequeReport(List<ChequeReport> list) {
		chequeReportRepository.saveAll(list);

	}

	@Override
	public void addChequeReport(ChequeReport chequeReport) throws Exception {
		if (exists(chequeReport.getTrId())) {
			throw new Exception("Transaction with " + chequeReport.getTrId() + " exists.");
		}
		chequeReportRepository.save(chequeReport);

	}

	@Override
	public ChequeReport viewChequeReport(int id) {
		Optional<ChequeReport> chequeReport = chequeReportRepository.findById(id);
		if (chequeReport.isPresent()) {
			return chequeReport.get();
		}
		return null;
	}

	@Override
	public void updateChequeReport(ChequeReport chequeReport) throws Exception {
		if (exists(chequeReport.getTrId())) {
			chequeReportRepository.save(chequeReport);
		}
		throw new Exception("Cheque Report Not Found");

	}

	@Override
	public boolean deleteChequeReport(int id) {
		if (exists(id)) {
			chequeReportRepository.deleteById(id);
			return true;
		}
		return false;
	}

	private boolean exists(int id) {
		return chequeReportRepository.existsById(id);
	}

}
