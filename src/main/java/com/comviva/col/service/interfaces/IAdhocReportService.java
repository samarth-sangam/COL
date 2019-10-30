package com.comviva.col.service.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.comviva.col.entity.AdhocReport;
import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.NotFoundException;

/**
 * Interface for AdhocReport Service.
 * 
 * @author samarth.sangam
 *
 */
public interface IAdhocReportService {

	String addAdhocReport(AdhocReport adhocReport) throws DuplicateException;

	String addAllAdhocReport(List<AdhocReport> list);

	String deleteAdhocReport(int id);

	AdhocReport viewAdhocReport(int id) throws NotFoundException;

	List<AdhocReport> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String id);

	List<AdhocReport> viewByMonth(String month, String id);
}
