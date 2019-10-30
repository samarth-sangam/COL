package com.comviva.col.dao.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.comviva.col.entity.AdhocReport;

/**
 * Interface for AdhocReport Database CRUD and view.
 * 
 * @author samarth.sangam
 *
 */
public interface IAdhocReportDao {

	void addAllAdhocReport(List<AdhocReport> adhocReport);

	void addAdhocReport(AdhocReport adhocReport) throws Exception;

	AdhocReport viewAdhocReport(int id);

	void updateAdhocReport(AdhocReport adhocReport) throws Exception;

	boolean deleteAdhocReport(int id);

	List<AdhocReport> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String externalId);

	List<AdhocReport> viewByMonth(String month, String id);

	void deleteByMonth(String month, String id);

}
