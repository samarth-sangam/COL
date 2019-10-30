package com.comviva.col.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comviva.col.dao.interfaces.IAdhocReportDao;
import com.comviva.col.entity.AdhocReport;
import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.NotFoundException;
import com.comviva.col.service.interfaces.IAdhocReportService;

/**
 * AdhocReport Service Implementation.
 * 
 * @author samarth.sangam
 *
 */
@Service
public class AdhocReportServiceImpl implements IAdhocReportService {

	@Autowired
	private IAdhocReportDao adhocReportDao;

	@Override
	public String addAdhocReport(AdhocReport adhocReport) throws DuplicateException {
		try {
			adhocReportDao.addAdhocReport(adhocReport);
		} catch (Exception e) {
			throw new DuplicateException(e);
		}
		return "Adhoc Report Added";
	}

	@Override
	public String addAllAdhocReport(List<AdhocReport> list) {
		adhocReportDao.addAllAdhocReport(list);
		return "Added";
	}

	@Override
	public String deleteAdhocReport(int id) {
		adhocReportDao.deleteAdhocReport(id);
		return "Deleted";
	}

	@Override
	public AdhocReport viewAdhocReport(int id) throws NotFoundException {
		AdhocReport adhocReport = adhocReportDao.viewAdhocReport(id);
		if (adhocReport == null) {
			throw new NotFoundException("Adhoc Report with Transaction Id " + id + "not found.");
		}
		return adhocReport;
	}

	@Override
	public List<AdhocReport> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String id) {
		return adhocReportDao.viewByFromAndToDate(fromDate, toDate, id);
	}

	@Override
	public List<AdhocReport> viewByMonth(String month, String id) {
		return adhocReportDao.viewByMonth(month, id);
	}

}
