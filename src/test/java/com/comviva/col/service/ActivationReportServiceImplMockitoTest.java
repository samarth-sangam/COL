/**
 * 
 */
package com.comviva.col.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.comviva.col.dao.ActivationReportDaoImpl;
import com.comviva.col.entity.ActivationReport;
import com.comviva.col.exceptions.NotFoundException;
import com.comviva.col.utils.dto.ActivationReportDto;

/**
 * @author samarth.sangam
 *
 */
@RunWith(MockitoJUnitRunner.class)
class ActivationReportServiceImplMockitoTest {

	private static final String EXISTS = "Exists";

	private static final String NOT_EXISTS = "Not Exists";

	@Mock
	private ActivationReportDaoImpl dao;

	private ActivationReportServiceImpl service = Mockito.mock(ActivationReportServiceImpl.class);

	private ActivationReport entity;

	private ActivationReportDto dto;

	private String trId = UUID.randomUUID().toString();

	private String agentCode;

	private LocalDate from = LocalDate.of(2019, 10, 01);

	private LocalDate to = LocalDate.of(2019, 11, 01);

	private List<ActivationReport> listEntity = new ArrayList<>();

	private List<ActivationReportDto> listDto = new ArrayList<>();

	private String month = "MARCH";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		agentCode = "100";
		entity = new ActivationReport();
		entity.setTrId(trId);
		entity.setAgentCode(agentCode);
		listEntity.add(entity);
		dto = new ActivationReportDto();
		dto.setAgentCode(agentCode);
		listDto.add(dto);
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.ActivationReportServiceImpl#viewByFromAndToDate(java.time.LocalDate, java.time.LocalDate, java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	final void testViewByFromAndToDate_Success() throws Exception {
		when(service.viewByFromAndToDate(from, to, agentCode)).thenReturn(listEntity);
		assertEquals(listEntity, service.viewByFromAndToDate(from, to, agentCode));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.ActivationReportServiceImpl#viewByFromAndToDate(java.time.LocalDate, java.time.LocalDate, java.lang.String)}.
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	final void testViewByFromAndToDate_Failure() throws Exception {
		try {
			when(service.viewByFromAndToDate(from, to, agentCode)).thenThrow(new NotFoundException(NOT_EXISTS));
			service.viewByFromAndToDate(from, to, agentCode);
			fail("failure");
		} catch (NotFoundException e) {
			assertEquals(NOT_EXISTS, e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.ActivationReportServiceImpl#addAllActivationReport(java.util.List)}.
	 */
	@Test
	final void testAddAllActivationReport() {
	}

}
