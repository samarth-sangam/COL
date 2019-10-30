package com.comviva.col.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comviva.col.dao.interfaces.IDeductionReportDao;
import com.comviva.col.entity.DeductionReport;
import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.NotFoundException;
import com.comviva.col.service.interfaces.IDeductionReportService;
import com.comviva.col.utils.dto.DeductionReportDto;
import com.comviva.col.utils.mapper.DeductionReportMapper;

/**
 * DeductionReport Service Implementation.
 * 
 * @author samarth.sangam
 *
 */
@Service
public class DeductionReportServiceImpl implements IDeductionReportService {

	@Autowired
	private IDeductionReportDao deductionReportDao;

	@Autowired
	private DeductionReportMapper mapper;

	@Override
	public String addDeductionReport(DeductionReport deductionReport) throws DuplicateException {
		try {
			deductionReportDao.addActivationReport(deductionReport);
		} catch (Exception e) {
			throw new DuplicateException(e);
		}
		return "Added";
	}

	@Override
	public String addAllDeductionReport(List<DeductionReportDto> list) {
		List<DeductionReport> deductionReportList = new ArrayList<>();
		for (DeductionReportDto dto : list) {
			deductionReportList.add(mapper.toEntity(dto));
		}
		deductionReportDao.addAllActivationReport(deductionReportList);
		return "All Added";
	}

	@Override
	public String deleteDeductionReport(int id) {
		deductionReportDao.deleteDeductionReport(id);
		return "Deleted";
	}

	@Override
	public DeductionReport viewDeductionReport(int id) throws NotFoundException {
		DeductionReport deductionReport = deductionReportDao.viewDeductionReport(id);
		if (deductionReport == null) {
			throw new NotFoundException("Deduction Report with Transaction Id " + id + "not found.");
		}
		return deductionReport;
	}

	@Override
	public List<DeductionReport> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String id) {
		return deductionReportDao.viewByFromAndToDate(fromDate, toDate, id);
	}

	@Override
	public List<DeductionReport> viewByMonth(String month, String id) {
		return deductionReportDao.viewByMonth(month, id);
	}

}
