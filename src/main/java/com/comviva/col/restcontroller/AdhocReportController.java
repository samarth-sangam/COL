package com.comviva.col.restcontroller;
/*
 * package com.comviva.col.controller;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.comviva.col.entity.AdhocReport; import
 * com.comviva.col.exceptions.DuplicateException; import
 * com.comviva.col.service.interfaces.IAdhocReportService;
 * 
 *//**
	 * REST apis for Adhoc Report.
	 * 
	 * @author samarth.sangam
	 *
	 */
/*
 * @RestController public class AdhocReportController {
 * 
 * @Autowired private IAdhocReportService adhocReportService;
 * 
 *//**
	 * REST api to add Adhoc Report.
	 * 
	 * @param adhocReport
	 * @return
	 * @throws DuplicateException
	 */
/*
 * @PostMapping(value = "/addAdhocReport") public String
 * addAdhocReport(@RequestBody AdhocReport adhocReport) throws
 * DuplicateException { adhocReportService.addAdhocReport(adhocReport); return
 * "Added"; }
 * 
 * // TODO: Inprogress.
 *//**
	 * REST api to add Adhoc Reports from filename.
	 * 
	 * @param filename
	 * @return
	 *//*
		 * @PostMapping(value = "/addAllAdhocReport") public String
		 * addAdhocReport(@RequestParam String filename) { // TODO: Adhoc from CSV
		 * return "All Added"; }
		 * 
		 * }
		 */