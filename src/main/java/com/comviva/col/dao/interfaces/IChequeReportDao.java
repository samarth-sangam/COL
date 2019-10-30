package com.comviva.col.dao.interfaces;

import java.util.List;

import com.comviva.col.entity.ChequeReport;

/**
 * Interface for ChequeReport Dao.
 * 
 * @author samarth.sangam
 *
 */
public interface IChequeReportDao {

	void addAllChequeReport(List<ChequeReport> list);

	void addChequeReport(ChequeReport chequeReport) throws Exception;

	ChequeReport viewChequeReport(int id);

	void updateChequeReport(ChequeReport chequeReport) throws Exception;

	boolean deleteChequeReport(int id);

}
