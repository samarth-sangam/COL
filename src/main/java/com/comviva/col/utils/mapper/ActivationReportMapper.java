package com.comviva.col.utils.mapper;

import org.springframework.stereotype.Component;

import com.comviva.col.entity.ActivationReport;
import com.comviva.col.utils.dto.ActivationReportDto;

/**
 * Mapper for ActivationReport.
 * 
 * @author samarth.sangam
 *
 */
@Component
public class ActivationReportMapper {

	/**
	 * Maps DTO to Entity Object.
	 * 
	 * @param activationReportDto
	 * @return
	 */
	public ActivationReport toEntity(ActivationReportDto activationReportDto) {
		ActivationReport activationReport = new ActivationReport();

		if (activationReportDto.getActiType() != null) {
			activationReport.setActiType(activationReportDto.getActiType());
		}
		if (activationReportDto.getActivationDate() != null) {
			activationReport.setActivationDate(activationReportDto.getActivationDate());
		}
		if (activationReportDto.getAgentCode() != null) {
			activationReport.setAgentCode(activationReportDto.getAgentCode());
		}
		if (activationReportDto.getCategory() != null) {
			activationReport.setCategory(activationReportDto.getCategory());
		}
		if (activationReportDto.getExternalId() != null) {
			activationReport.setExternalId(activationReportDto.getExternalId());
		}
		if (activationReportDto.getIncentive() != null) {
			activationReport.setIncentive(activationReportDto.getIncentive());
		}
		if (activationReportDto.getMobileNumber() != null) {
			activationReport.setMobileNumber(activationReportDto.getMobileNumber());
		}
		if (activationReportDto.getMonth() != null) {
			activationReport.setMonth(activationReportDto.getMonth());
		}
		if (activationReportDto.getName() != null) {
			activationReport.setName(activationReportDto.getName());
		}
		if (activationReportDto.getScheme() != null) {
			activationReport.setScheme(activationReportDto.getScheme());
		}
		if (activationReportDto.getStatus() != null) {
			activationReport.setStatus(activationReportDto.getStatus());
		}
		return activationReport;
	}

	/**
	 * Maps Entity to DTO.
	 * 
	 * @param activationReport
	 * @return
	 */
	public ActivationReportDto toDTO(ActivationReport activationReport) {
		ActivationReportDto activationReportDto = new ActivationReportDto();

		if (activationReport.getActiType() != null) {
			activationReportDto.setActiType(activationReport.getActiType());
		}
		if (activationReport.getActivationDate() != null) {
			activationReportDto.setActivationDate(activationReport.getActivationDate());
		}
		if (activationReport.getAgentCode() != null) {
			activationReportDto.setAgentCode(activationReport.getAgentCode());
		}
		if (activationReport.getCategory() != null) {
			activationReportDto.setCategory(activationReport.getCategory());
		}
		if (activationReport.getExternalId() != null) {
			activationReportDto.setExternalId(activationReport.getExternalId());
		}
		if (activationReport.getIncentive() != null) {
			activationReportDto.setIncentive(activationReport.getIncentive());
		}
		if (activationReport.getMobileNumber() != null) {
			activationReportDto.setMobileNumber(activationReport.getMobileNumber());
		}
		if (activationReport.getMonth() != null) {
			activationReportDto.setMonth(activationReport.getMonth());
		}
		if (activationReport.getName() != null) {
			activationReportDto.setName(activationReport.getName());
		}
		if (activationReport.getScheme() != null) {
			activationReportDto.setScheme(activationReport.getScheme());
		}
		return activationReportDto;
	}

}
