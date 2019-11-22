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
	int addAllActivationReport(List<ActivationReport> list);

	/**
	 * View Activation Reports of AgentCode from a particular date to a particular
	 * date.
	 * 
	 * @param fromDate
	 * @param toDate
	 * @param externalId
	 * @return
	 * @throws Exception
	 */
	List<ActivationReport> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String externalId)
			throws Exception;

}
