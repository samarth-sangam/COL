package com.comviva.col.utils.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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
class ActivationReportMapperTest {

	private ActivationReportMapper mapper = Mockito.mock(ActivationReportMapper.class);

	private ActivationReport entity = new ActivationReport();

	private ActivationReportDto dto = new ActivationReportDto();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		entity.setAgentCode("100");
		dto.setAgentCode("100");
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
