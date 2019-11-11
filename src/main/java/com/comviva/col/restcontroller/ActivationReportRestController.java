package com.comviva.col.restcontroller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.NotFoundException;
import com.comviva.col.service.FileStorageService;
import com.comviva.col.service.interfaces.IActivationReportService;
import com.comviva.col.utils.dto.ActivationReportDto;
import com.comviva.col.utils.mapper.ActivationReportMapper;
import com.comviva.col.utils.mapper.CSVToEntity;

/**
 * REST apis for ActivationReport.
 * 
 * @author samarth.sangam, mahendra.prajapati
 * @since 28-October-2019
 */
@RestController
@RequestMapping(value = "/api/v1/activationReport/")
public class ActivationReportRestController {

	@Autowired
	private IActivationReportService activationReportService;

	@Autowired
	private ActivationReportMapper mapper;
	
	private Logger log = Logger.getLogger(ActivationReportRestController.class);

	@Autowired
	private FileStorageService fileStorageService;

	/**
	 * REST api to add ActivationReport.
	 * 
	 * @param activationReportdto
	 * @return
	 * @throws DuplicateException
	 */
	@PreAuthorize("hasAnyRole('CIRCLE', 'ADMIN')")
	@PostMapping(value = "/activationReport")
	@CrossOrigin
	public ResponseEntity<?> addActivationReport(@RequestBody ActivationReportDto activationReportdto)
			throws DuplicateException {
		log.info("Url pattern /api/v1/activationReport/activationReport invoked for adding single report.");
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
	@PreAuthorize("hasAnyRole('CIRCLE', 'ADMIN')")
	@PostMapping(value = "/allActivationReport")
	@CrossOrigin
	public ResponseEntity<?> addAllActivationReport(@RequestParam("file") MultipartFile file) throws IOException {
		log.info("Url pattern /api/v1/activationReport/allActivationReport invoked for adding report in bulk.");
		String fileName = fileStorageService.storeFile(file);
		List<ActivationReportDto> list = CSVToEntity.getInstance().readCSVFileIntoActivationReportObject(fileName);
		if(list == null)
			log.error("Failed to convert csv to list. List object is identified as null.");
		activationReportService.addAllActivationReport(list);
		log.info("All reports are added by csv.");
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
	@PreAuthorize("hasAnyRole('USER', 'CIRCLE', 'ADMIN')")
	@GetMapping(value = "/allActivationReport")
	@CrossOrigin
	public ResponseEntity<?> viewActivationReportFromAndToDate(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String agentCode) throws NotFoundException {
		log.info("Url pattern /api/v1/activationReport/allActivationReport invoked for seaching the activation report from("+fromDate+"), toDate("+toDate+") agentCode("+agentCode+")");
		return ResponseEntity.ok(activationReportService.viewByFromAndToDate(LocalDate.parse(fromDate),
				LocalDate.parse(toDate), agentCode));
	}

}
