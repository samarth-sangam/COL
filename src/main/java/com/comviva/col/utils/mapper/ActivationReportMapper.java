package com.comviva.col.utils.mapper;

import org.modelmapper.ModelMapper;

import com.comviva.col.entity.ActivationReport;
import com.comviva.col.utils.dto.ActivationReportDto;

/**
 * Mapper for ActivationReport.
 * 
 * @author samarth.sangam
 *
 */
public class ActivationReportMapper {

	private ModelMapper modelMapper = new ModelMapper();

	/**
	 * Maps DTO to Entity Object.
	 * 
	 * @param activationReportDto
	 * @return
	 */
	public ActivationReport toEntity(ActivationReportDto activationReportDto) {
		return modelMapper.map(activationReportDto, ActivationReport.class);
	}

	/**
	 * Maps Entity to DTO.
	 * 
	 * @param activationReport
	 * @return
	 */
	public ActivationReportDto toDto(ActivationReport activationReport) {
		return modelMapper.map(activationReport, ActivationReportDto.class);
	}

}
