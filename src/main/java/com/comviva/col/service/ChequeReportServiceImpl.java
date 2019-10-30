package com.comviva.col.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comviva.col.dao.interfaces.IChequeReportDao;
import com.comviva.col.entity.ChequeReport;
import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.NotFoundException;
import com.comviva.col.service.interfaces.IChequeReportService;
import com.comviva.col.utils.dto.ChequeReportDto;
import com.comviva.col.utils.mapper.ChequeReportMapper;

/**
 * ChequeReport Service Implementation.
 * 
 * @author samarth.sangam
 *
 */
@Service
public class ChequeReportServiceImpl implements IChequeReportService {

	@Autowired
	private IChequeReportDao chequeReportDao;

	@Autowired
	private ChequeReportMapper mapper;

	@Override
	public String addChequeReport(ChequeReport chequeReport) throws DuplicateException {
		try {
			chequeReportDao.addChequeReport(chequeReport);
		} catch (Exception e) {
			throw new DuplicateException(e);
		}
		return "Cheque Report Added";
	}

	@Override
	public String addAllChequeReport(List<ChequeReportDto> list) {
		List<ChequeReport> chequeReportList = new ArrayList<>();
		for (ChequeReportDto dto : list) {
			chequeReportList.add(mapper.toEntity(dto));
		}
		chequeReportDao.addAllChequeReport(chequeReportList);
		return "All Added";
	}

	@Override
	public String deleteChequeReport(int id) {
		chequeReportDao.deleteChequeReport(id);
		return "Deleted";
	}

	@Override
	public ChequeReport viewChequeReport(int id) throws NotFoundException {
		ChequeReport chequeReport = chequeReportDao.viewChequeReport(id);
		if (chequeReport == null) {
			throw new NotFoundException("Cheque Report with Transaction Id " + id + "not found.");
		}
		return chequeReport;
	}

}
