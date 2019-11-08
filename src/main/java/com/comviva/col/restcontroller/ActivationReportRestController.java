package com.comviva.col.restcontroller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.NotFoundException;
import com.comviva.col.service.interfaces.IActivationReportService;
import com.comviva.col.utils.dto.ActivationReportDto;
import com.comviva.col.utils.mapper.ActivationReportMapper;
import com.comviva.col.utils.mapper.CSVToEntity;

/**
 * REST apis for ActivationReport.
 * 
 * @author samarth.sangam
 * @since 28-October-2019
 */
@RestController
@RequestMapping(value = "/api/v1/activationReport/")
public class ActivationReportRestController {

	@Autowired
	private IActivationReportService activationReportService;

	@Autowired
	private ActivationReportMapper mapper;

	/**
	 * REST api to add ActivationReport.
	 * 
	 * @param activationReportdto
	 * @return
	 * @throws DuplicateException
	 */
	@PostMapping(value = "/activationReport")
	@CrossOrigin
	public ResponseEntity<?> addActivationReport(@RequestBody ActivationReportDto activationReportdto)
			throws DuplicateException {
		return ResponseEntity.ok(activationReportService.addActivationReport(mapper.toEntity(activationReportdto)));
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
	@CrossOrigin
	public ResponseEntity<?> addAllActivationReport(@RequestParam String filename) throws IOException {
		List<ActivationReportDto> list = CSVToEntity.getInstance().readCSVFileIntoActivationReportObject(filename);
		activationReportService.addAllActivationReport(list);
		return ResponseEntity.ok("All Added");
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
	@CrossOrigin
	public ResponseEntity<?> viewActivationReportFromAndToDate(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String agentCode) throws NotFoundException {
		return ResponseEntity.ok(activationReportService.viewByFromAndToDate(LocalDate.parse(fromDate),
				LocalDate.parse(toDate), agentCode));
	}

}
