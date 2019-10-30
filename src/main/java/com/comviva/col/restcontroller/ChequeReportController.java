package com.comviva.col.restcontroller;
/*
 * package com.comviva.col.controller;
 * 
 * import java.io.IOException; import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.comviva.col.entity.ChequeReport; import
 * com.comviva.col.exceptions.DuplicateException; import
 * com.comviva.col.service.interfaces.IChequeReportService; import
 * com.comviva.col.utils.dto.ChequeReportDto; import
 * com.comviva.col.utils.mapper.CSVToEntity;
 * 
 *//**
	 * REST apis for Cheque Report.
	 * 
	 * @author samarth.sangam
	 *
	 */
/*
 * @RestController public class ChequeReportController {
 * 
 * @Autowired private IChequeReportService chequeReportService;
 * 
 *//**
	 * REST api to add Cheque Report.
	 * 
	 * @param chequeReport
	 * @return
	 * @throws DuplicateException
	 */
/*
 * @PostMapping public String addChequeReport(@RequestBody ChequeReport
 * chequeReport) throws DuplicateException {
 * chequeReportService.addChequeReport(chequeReport); return "Added"; }
 * 
 *//**
	 * REST api to add Cheque Reports from the csv.
	 * 
	 * @param filename path to csv.
	 * @return
	 * @throws IOException
	 *//*
		 * @PostMapping(value = "/addAllChequeReport") public String
		 * addAllChequeReport(@RequestParam String filename) throws IOException {
		 * List<ChequeReportDto> list =
		 * CSVToEntity.getInstance().readCSVFileIntoChequeReportObject(filename);
		 * chequeReportService.addAllChequeReport(list); return "All Added"; }
		 * 
		 * }
		 */