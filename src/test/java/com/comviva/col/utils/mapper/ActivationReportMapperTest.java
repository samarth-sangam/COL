package com.comviva.col.utils.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.comviva.col.entity.ActivationReport;
import com.comviva.col.utils.dto.ActivationReportDto;

/**
 * @author samarth.sangam
 *
 */
class ActivationReportMapperTest {

	private ActivationReportMapper mapper = new ActivationReportMapper();

	private ActivationReport entity;

	private ActivationReportDto dto;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		entity = new ActivationReport();
		entity.setAgentCode("100");
		entity.setActiType("actiType");
		LocalDateTime now = LocalDateTime.now();
		entity.setActivationDate(now);
		entity.setAmount("amount");
		entity.setCategory("category");
		entity.setExternalId("externalId");
		entity.setIncentive("incentive");
		entity.setMobileNumber("mobileNumber");
		entity.setMonth("month");
		entity.setName("name");
		entity.setScheme("scheme");
		entity.setStatus('y');
		entity.setTrId(UUID.randomUUID().toString());

		dto = new ActivationReportDto();
		dto.setAgentCode("100");
		dto.setActivationDate(now);
		dto.setAmount("amount");
		dto.setActiType("actiType");
		dto.setCategory("category");
		dto.setExternalId("externalId");
		dto.setIncentive("incentive");
		dto.setMobileNumber("mobileNumber");
		dto.setMonth("month");
		dto.setName("name");
		dto.setScheme("scheme");
		dto.setStatus('y');
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.utils.mapper.ActivationReportMapper#toEntity(com.comviva.col.utils.dto.ActivationReportDto)}.
	 */
	@Test
	final void testToEntity() {
		ActivationReport actual = mapper.toEntity(dto);
		assertEquals(entity.getActiType(), actual.getActiType());
		assertEquals(entity.getActivationDate(), actual.getActivationDate());
		assertEquals(entity.getAgentCode(), actual.getAgentCode());
		assertEquals(entity.getAmount(), actual.getAmount());
		assertEquals(entity.getCategory(), actual.getCategory());
		assertEquals(entity.getExternalId(), actual.getExternalId());
		assertEquals(entity.getIncentive(), actual.getIncentive());
		assertEquals(entity.getMobileNumber(), actual.getMobileNumber());
		assertEquals(entity.getMonth(), actual.getMonth());
		assertEquals(entity.getName(), actual.getName());
		assertEquals(entity.getScheme(), actual.getScheme());
		assertEquals(entity.getStatus(), actual.getStatus());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.utils.mapper.ActivationReportMapper#toDto(com.comviva.col.entity.ActivationReport)}.
	 */
	@Test
	final void testToDTO() {
		assertEquals(dto.getActiType(), mapper.toDto(entity).getActiType());
		assertEquals(dto.getActivationDate(), mapper.toDto(entity).getActivationDate());
		assertEquals(dto.getAgentCode(), mapper.toDto(entity).getAgentCode());
		assertEquals(dto.getAmount(), mapper.toDto(entity).getAmount());
		assertEquals(dto.getCategory(), mapper.toDto(entity).getCategory());
		assertEquals(dto.getExternalId(), mapper.toDto(entity).getExternalId());
		assertEquals(dto.getIncentive(), mapper.toDto(entity).getIncentive());
		assertEquals(dto.getMobileNumber(), mapper.toDto(entity).getMobileNumber());
		assertEquals(dto.getMonth(), mapper.toDto(entity).getMonth());
		assertEquals(dto.getName(), mapper.toDto(entity).getName());
		assertEquals(dto.getScheme(), mapper.toDto(entity).getScheme());
		assertEquals(dto.getStatus(), mapper.toDto(entity).getStatus());
	}

}
