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
	protected ActivationReportMapper mapper = new ActivationReportMapper();
	@Autowired
	private IActivationReportDao activationReportDao;

	private Logger log = Logger.getLogger(ActivationReportServiceImpl.class);

	@Override
	public List<ActivationReport> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String agentCode)
			throws Exception {
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
	public void addAllActivationReport(List<ActivationReportDto> list) throws DuplicateException {
		List<ActivationReport> activationReportList = new ArrayList<>();
		for (ActivationReportDto obj : list) {
			activationReportList.add(mapper.toEntity(obj));
		}
		int inserted = activationReportDao.addAllActivationReport(activationReportList);
		if (inserted != 0) {
			throw new DuplicateException("Could Not Insert " + inserted + " Data because of duplicate values");
		}
	}

}
