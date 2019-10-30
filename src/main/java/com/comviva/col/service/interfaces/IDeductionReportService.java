package com.comviva.col.service.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.comviva.col.entity.DeductionReport;
import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.NotFoundException;
import com.comviva.col.utils.dto.DeductionReportDto;

/**
 * Interface DeductionReport Service.
 * 
 * @author samarth.sangam
 *
 */
public interface IDeductionReportService {

	String addDeductionReport(DeductionReport deductionReport) throws DuplicateException;

	String addAllDeductionReport(List<DeductionReportDto> list);

	String deleteDeductionReport(int id);

	DeductionReport viewDeductionReport(int id) throws NotFoundException;

	List<DeductionReport> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String id);

	List<DeductionReport> viewByMonth(String month, String id);
}
