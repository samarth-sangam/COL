package com.comviva.col.service.interfaces;

import java.util.List;

import com.comviva.col.entity.ChequeReport;
import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.NotFoundException;
import com.comviva.col.utils.dto.ChequeReportDto;

/**
 * Interface for ChequeReport Service.
 * 
 * @author samarth.sangam
 *
 */
public interface IChequeReportService {

	String addChequeReport(ChequeReport chequeReport) throws DuplicateException;

	String addAllChequeReport(List<ChequeReportDto> list);

	String deleteChequeReport(int id);

	ChequeReport viewChequeReport(int id) throws NotFoundException;

}
