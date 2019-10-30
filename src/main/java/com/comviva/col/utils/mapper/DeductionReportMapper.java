package com.comviva.col.utils.mapper;

import org.springframework.stereotype.Component;

import com.comviva.col.entity.DeductionReport;
import com.comviva.col.utils.dto.DeductionReportDto;

@Component
public class DeductionReportMapper {

	public DeductionReport toEntity(DeductionReportDto deductionReportDto) {
		DeductionReport deductionReport = new DeductionReport();
		if (deductionReportDto.getActiType() != null) {
			deductionReport.setActiType(deductionReportDto.getActiType());
		}
		if (deductionReportDto.getActivationDate() != null) {
			deductionReport.setActivationDate(deductionReportDto.getActivationDate());
		}
		if (deductionReportDto.getAgentCode() != null) {
			deductionReport.setAgentCode(deductionReportDto.getAgentCode());
		}
		if (deductionReportDto.getAmount() != null) {
			deductionReport.setAmount(deductionReportDto.getAmount());
		}
		if (deductionReportDto.getCategory() != null) {
			deductionReport.setCategory(deductionReportDto.getCategory());
		}
		if (deductionReportDto.getExternalId() != null) {
			deductionReport.setExternalId(deductionReportDto.getExternalId());
		}
		if (deductionReportDto.getMobileNumber() != null) {
			deductionReport.setMobileNumber(deductionReportDto.getMobileNumber());
		}
		if (deductionReportDto.getMonth() != null) {
			deductionReport.setMonth(deductionReportDto.getMonth());
		}
		if (deductionReportDto.getName() != null) {
			deductionReport.setName(deductionReportDto.getName());
		}
		if (deductionReportDto.getRemarks1() != null) {
			deductionReport.setRemarks1(deductionReportDto.getRemarks1());
		}
		if (deductionReportDto.getRemarks2() != null) {
			deductionReport.setRemarks2(deductionReportDto.getRemarks2());
		}
		if (deductionReportDto.getScheme() != null) {
			deductionReport.setScheme(deductionReportDto.getScheme());
		}

		return deductionReport;
	}

	public DeductionReportDto toDto(DeductionReport deductionReport) {
		DeductionReportDto deductionReportDto = new DeductionReportDto();
		if (deductionReport.getActiType() != null) {
			deductionReportDto.setActiType(deductionReport.getActiType());
		}
		if (deductionReport.getActivationDate() != null) {
			deductionReportDto.setActivationDate(deductionReport.getActivationDate());
		}
		if (deductionReport.getAgentCode() != null) {
			deductionReportDto.setAgentCode(deductionReport.getAgentCode());
		}
		if (deductionReport.getAmount() != null) {
			deductionReportDto.setAmount(deductionReport.getAmount());
		}
		if (deductionReport.getCategory() != null) {
			deductionReportDto.setCategory(deductionReport.getCategory());
		}
		if (deductionReport.getExternalId() != null) {
			deductionReportDto.setExternalId(deductionReport.getExternalId());
		}
		if (deductionReport.getMobileNumber() != null) {
			deductionReportDto.setMobileNumber(deductionReport.getMobileNumber());
		}
		if (deductionReport.getMonth() != null) {
			deductionReportDto.setMonth(deductionReport.getMonth());
		}
		if (deductionReport.getName() != null) {
			deductionReportDto.setName(deductionReport.getName());
		}
		if (deductionReport.getRemarks1() != null) {
			deductionReportDto.setRemarks1(deductionReport.getRemarks1());
		}
		if (deductionReport.getRemarks2() != null) {
			deductionReportDto.setRemarks2(deductionReport.getRemarks2());
		}
		if (deductionReport.getScheme() != null) {
			deductionReportDto.setScheme(deductionReport.getScheme());
		}

		return deductionReportDto;
	}

}
