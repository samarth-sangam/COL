package com.comviva.col.restcontroller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comviva.col.entity.ActivationReport;
import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.NotFoundException;
import com.comviva.col.service.interfaces.IActivationReportService;
import com.comviva.col.utils.dto.ActivationReportDto;
import com.comviva.col.utils.mapper.CSVToEntity;

/**
 * Activation Report Rest Controller.
 * 
 * @author samarth.sangam
 * @since 28-October-2019
 */
@RestController
public class ActivationReportController {

	@Autowired
	private IActivationReportService activationReportService;

	/**
	 * REST api to add ActivationReport.
	 * 
	 * @param activationReport
	 * @return
	 * @throws DuplicateException
	 */
	@PostMapping(value = "/activationReport")
	public String addActivationReport(@RequestBody ActivationReport activationReport) throws DuplicateException {
		activationReportService.addActivationReport(activationReport);
		return "Added";
	}

	/**
	 * REST api to add ActivationReports from csv file.
	 * 
	 * @param filename File path to csv file.
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@PostMapping(value = "/allActivationReport")
	public String addAllActivationReport(@RequestParam String filename) throws FileNotFoundException, IOException {
		List<ActivationReportDto> list = CSVToEntity.getInstance().readCSVFileIntoActivationReportObject(filename);
		activationReportService.addAllActivationReport(list);
		return "All Added";
	}

	/**
	 * REST api to view ActivationReports from particular data to a particular date.
	 * 
	 * @param fromDate
	 * @param toDate
	 * @param agentCode
	 * @return
	 * @throws NotFoundException
	 */
	@GetMapping(value = "/allActivationReport")
	public List<ActivationReport> viewActivationReportFromAndToDate(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String agentCode) throws NotFoundException {
		return activationReportService.viewByFromAndToDate(LocalDate.parse(fromDate), LocalDate.parse(toDate),
				agentCode);
	}

}
