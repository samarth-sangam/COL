package com.comviva.col.dao.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.comviva.col.entity.DeductionReport;

/**
 * Interface for DeductionReport dao.
 * 
 * @author samarth.sangam
 *
 */
public interface IDeductionReportDao {

	void addAllActivationReport(List<DeductionReport> deductionReport);

	void addActivationReport(DeductionReport deductionReport) throws Exception;

	DeductionReport viewDeductionReport(int id);

	void updateDeductionReport(DeductionReport deductionReport) throws Exception;

	boolean deleteDeductionReport(int id);

	List<DeductionReport> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String externalId);

	List<DeductionReport> viewByMonth(String month, String id);

	void deleteByMonth(String month, String id);

}
