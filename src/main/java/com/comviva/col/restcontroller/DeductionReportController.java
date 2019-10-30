package com.comviva.col.restcontroller;
/*
 * package com.comviva.col.controller;
 * 
 * import java.io.IOException; import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.comviva.col.entity.DeductionReport; import
 * com.comviva.col.exceptions.DuplicateException; import
 * com.comviva.col.service.interfaces.IDeductionReportService; import
 * com.comviva.col.utils.dto.DeductionReportDto; import
 * com.comviva.col.utils.mapper.CSVToEntity;
 * 
 *//**
	 * REST apis for Deduction Report.
	 * 
	 * @author samarth.sangam
	 *
	 */
/*
 * @RestController public class DeductionReportController {
 * 
 * @Autowired private IDeductionReportService deductionReportService;
 * 
 *//**
	 * REST api to add Deduction Report.
	 * 
	 * @param deductionReport
	 * @return
	 * @throws DuplicateException
	 */
/*
 * @GetMapping(value = "/addDeductionReport") public String
 * addDeductionReport(@RequestBody DeductionReport deductionReport) throws
 * DuplicateException {
 * deductionReportService.addDeductionReport(deductionReport); return "Added"; }
 * 
 *//**
	 * REST api to add Deduction Reports from csv.
	 * 
	 * @param filename path to csv.
	 * @return
	 * @throws IOException
	 *//*
		 * @GetMapping(value = "addAllDeductionReport") public String
		 * addAllDeductionReport(@RequestParam String filename) throws IOException {
		 * List<DeductionReportDto> list =
		 * CSVToEntity.getInstance().readCSVFileIntoDeductionReportObject(filename);
		 * deductionReportService.addAllDeductionReport(list); return "All Added"; } }
		 */