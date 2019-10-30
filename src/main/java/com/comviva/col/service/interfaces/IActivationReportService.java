package com.comviva.col.service.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.comviva.col.entity.ActivationReport;
import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.NotFoundException;
import com.comviva.col.utils.dto.ActivationReportDto;

/**
 * Interface for ActivationReport Service.
 * 
 * @author samarth.sangam
 *
 */
public interface IActivationReportService {

	/**
	 * Adds ActivationReport into database if doesnot exists else throws
	 * DuplicateException.
	 * 
	 * @param activationReport
	 * @return
	 * @throws DuplicateException
	 */
	String addActivationReport(ActivationReport activationReport) throws DuplicateException;

	/**
	 * Adds list of ActivationReport by converting Dto to entity.
	 * 
	 * @param list
	 * @return
	 */
	String addAllActivationReport(List<ActivationReportDto> list);

	String deleteActivationReport(int id);

	/**
	 * View ActivationReport by Transaction Id if exists else throws
	 * NotFoundException.
	 * 
	 * @param id
	 * @return
	 * @throws NotFoundException
	 */
	ActivationReport viewActivationReport(int id) throws NotFoundException;

	/**
	 * View List of ActivationReports added between fromDate and toDate by Agent
	 * with agentCode.
	 * 
	 * @param fromDate
	 * @param toDate
	 * @param agentCode
	 * @return
	 * @throws NotFoundException
	 */
	List<ActivationReport> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String agentCode)
			throws NotFoundException;

	/**
	 * View List of ActivationReports added in particular date by Agent with
	 * agentCode.
	 * 
	 * @param month
	 * @param agentCode
	 * @return
	 */
	List<ActivationReport> viewByMonth(String month, String agentCode);
}
