package com.comviva.col.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
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
 * @author samarth.sangam, mahendra.prajapati
 *
 */
@Service
public class ActivationReportServiceImpl implements IActivationReportService {

	@Autowired
	protected ActivationReportMapper mapper;
	@Autowired
	private IActivationReportDao activationReportDao;

	private Logger log = Logger.getLogger(ActivationReportServiceImpl.class);

	@Override
	public ActivationReport addActivationReport(ActivationReport activationReport) throws DuplicateException {
		try {
			log.info("Adding activation report");
			return activationReportDao.addActivationReport(activationReport);
		} catch (Exception e) {
			log.error("Exception : " + e.getMessage(), e);
			throw new DuplicateException(e);
		}
	}

	@Override
	public String deleteActivationReport(int id) throws NotFoundException {
		log.info("deletion by id(" + id + ") started.");
		if (activationReportDao.deleteActivationReport(id)) {
			return "ACtivation Report Deleted";
		}
		NotFoundException notFoundException = new NotFoundException(
				"ActivationReport with id " + id + " does not exists.");
		log.error("Exception occured : NotFoundException", notFoundException);
		throw notFoundException;
	}

	@Override
	public ActivationReport viewActivationReport(int id) throws NotFoundException {
		log.info("view by activation id(" + id + ") started.");
		ActivationReport activationReport = activationReportDao.viewActivationReport(id);
		if (activationReport == null) {
			NotFoundException notFoundException = new NotFoundException(
					"Activation Report with Transaction Id " + id + "not found.");
			log.error("Activation report not found with the id(" + id + ")", notFoundException);
			throw notFoundException;
		}

		return activationReport;
	}

	@Override
	public List<ActivationReport> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String agentCode)
			throws NotFoundException {
		List<ActivationReport> list = activationReportDao.viewByFromAndToDate(fromDate, toDate, agentCode);
		if (list == null) {
			NotFoundException notFoundException = new NotFoundException(
					"No Activation Report found from " + fromDate + " to" + toDate);
			log.error("No activation record found between range " + fromDate + " -> " + toDate + "with agentCode",
					notFoundException);
			throw notFoundException;
		}
		return list;
	}

	@Override
	public List<ActivationReport> addAllActivationReport(List<ActivationReportDto> list) {
		List<ActivationReport> activationReportList = new ArrayList<>();
		for (ActivationReportDto obj : list) {
			activationReportList.add(mapper.toEntity(obj));
		}
		return activationReportDao.addAllActivationReport(activationReportList);
	}

	@Override
	public List<ActivationReport> viewByMonth(String month, String id) {
		return activationReportDao.viewByMonth(month, id);
	}

}
