package com.comviva.col.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comviva.col.dao.interfaces.IActivationReportDao;
import com.comviva.col.entity.ActivationReport;
import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.NotFoundException;
import com.comviva.col.service.interfaces.IActivationReportService;
import com.comviva.col.utils.dto.ActivationReportDto;
import com.comviva.col.utils.mapper.ActivationReportMapper;

/**
 * Activation Report Service implementations.
 * 
 * @author samarth.sangam
 *
 */
@Service
public class ActivationReportServiceImpl implements IActivationReportService {

	@Autowired
	protected ActivationReportMapper mapper;
	@Autowired
	private IActivationReportDao activationReportDao;

	@Override
	public String addActivationReport(ActivationReport activationReport) throws DuplicateException {
		try {
			activationReportDao.addActivationReport(activationReport);
		} catch (Exception e) {
			throw new DuplicateException(e);
		}
		return "Activation Report Added";
	}

	@Override
	public String deleteActivationReport(int id) {
		activationReportDao.deleteActivationReport(id);
		return "ACtivation Report Deleted";
	}

	@Override
	public ActivationReport viewActivationReport(int id) throws NotFoundException {
		ActivationReport activationReport = activationReportDao.viewActivationReport(id);
		if (activationReport == null) {
			throw new NotFoundException("Activation Report with Transaction Id " + id + "not found.");
		}
		return activationReport;
	}

	@Override
	public List<ActivationReport> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String agentCode)
			throws NotFoundException {
		List<ActivationReport> list = activationReportDao.viewByFromAndToDate(fromDate, toDate, agentCode);
		if (list == null) {
			throw new NotFoundException("No Activation Report found from " + fromDate + " to" + toDate);
		}
		return list;
	}

	@Override
	public String addAllActivationReport(List<ActivationReportDto> list) {
		List<ActivationReport> activationReportList = new ArrayList<>();
		for (ActivationReportDto obj : list) {
			activationReportList.add(mapper.toEntity(obj));
		}
		activationReportDao.addAllActivationReport(activationReportList);
		return "All Activation Report Added";
	}

	@Override
	public List<ActivationReport> viewByMonth(String month, String id) {
		return activationReportDao.viewByMonth(month, id);
	}

}
