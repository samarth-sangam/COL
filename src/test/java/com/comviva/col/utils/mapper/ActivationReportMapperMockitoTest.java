package com.comviva.col.utils.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.comviva.col.entity.ActivationReport;
import com.comviva.col.utils.dto.ActivationReportDto;

/**
 * @author samarth.sangam
 *
 */
@RunWith(MockitoJUnitRunner.class)
class ActivationReportMapperMockitoTest {

	private ActivationReportMapper mapper = Mockito.mock(ActivationReportMapper.class);

	private ActivationReport entity = new ActivationReport();

	private ActivationReportDto dto = new ActivationReportDto();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		entity.setAgentCode("100");
		entity.setActiType("actiType");
		entity.setActivationDate(LocalDate.now());
		entity.setAmount("amount");
		entity.setCategory("category");
		entity.setExternalId("externalId");
		entity.setIncentive("incentive");
		entity.setMobileNumber("mobileNumber");
		entity.setMonth("month");
		entity.setName("name");
		entity.setScheme("scheme");
		entity.setStatus('y');
		entity.setTrId(1);

		dto.setAgentCode("100");
		dto.setActivationDate(LocalDate.now());
		dto.setAmount("amount");
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
		when(mapper.toEntity(dto)).thenReturn(entity);
		assertEquals(entity, mapper.toEntity(dto));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.utils.mapper.ActivationReportMapper#toDTO(com.comviva.col.entity.ActivationReport)}.
	 */
	@Test
	final void testToDTO() {
		when(mapper.toDTO(entity)).thenReturn(dto);
		assertEquals(dto, mapper.toDTO(entity));
	}

}
