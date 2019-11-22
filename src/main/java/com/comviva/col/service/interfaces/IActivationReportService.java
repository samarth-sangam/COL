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
 * @author samarth.sangam, mahendra.prajapati
 *
 */
public interface IActivationReportService {

	/**
	 * Adds list of ActivationReport by converting Dto to entity.
	 * 
	 * @param list
	 * @return
	 * @throws DuplicateException
	 */
	void addAllActivationReport(List<ActivationReportDto> list) throws DuplicateException;

	/**
	 * View List of ActivationReports added between fromDate and toDate by Agent
	 * with agentCode.
	 * 
	 * @param fromDate
	 * @param toDate
	 * @param agentCode
	 * @return
	 * @throws NotFoundException
	 * @throws Exception
	 */
	List<ActivationReport> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String agentCode)
			throws NotFoundException, Exception;
}
