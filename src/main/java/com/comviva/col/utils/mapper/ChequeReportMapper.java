package com.comviva.col.utils.mapper;

import org.springframework.stereotype.Component;

import com.comviva.col.entity.ChequeReport;
import com.comviva.col.utils.dto.ChequeReportDto;

/**
 * 
 * @author samarth.sangam
 *
 */
@Component
public class ChequeReportMapper {

	public ChequeReport toEntity(ChequeReportDto chequeReportDto) {
		ChequeReport chequeReport = new ChequeReport();
		if (chequeReportDto.getAgentCode() != null) {
			chequeReport.setAgentCode(chequeReportDto.getAgentCode());
		}
		if (chequeReportDto.getNoOfCheques() != null) {
			chequeReportDto.setNoOfCheques(chequeReportDto.getNoOfCheques());
		}

		return chequeReport;
	}

	public ChequeReportDto toDto(ChequeReport chequeReport) {
		ChequeReportDto chequeReportDto = new ChequeReportDto();
		if (chequeReport.getAgentCode() != null) {
			chequeReportDto.setAgentCode(chequeReport.getAgentCode());
		}
		if (chequeReport.getNoOfCheques() != null) {
			chequeReport.setNoOfCheques(chequeReport.getNoOfCheques());
		}

		return chequeReportDto;
	}
}
