package com.comviva.col.dao.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.comviva.col.entity.ActivationReport;

/**
 * Interface for Activation Report DAO.
 * 
 * @author samarth.sangam, mahendra.prajapti
 *
 */
public interface IActivationReportDao {

	/**
	 * Adds Activation Report to the database.
	 * 
	 * @param list
	 * @return
	 */
	List<ActivationReport> addAllActivationReport(List<ActivationReport> list);

	ActivationReport addActivationReport(ActivationReport activationReport) throws Exception;

	ActivationReport viewActivationReport(int id);

	ActivationReport updateActivationReport(ActivationReport activationReport) throws Exception;

	boolean deleteActivationReport(int id);

	List<ActivationReport> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String externalId);

	List<ActivationReport> viewByMonth(String month, String id);

	void deleteByMonth(String month, String id);

}
