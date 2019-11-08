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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.comviva.col.dao.ActivationReportDaoImpl;
import com.comviva.col.entity.ActivationReport;
import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.NotFoundException;
import com.comviva.col.utils.dto.ActivationReportDto;

/**
 * @author samarth.sangam
 *
 */
@RunWith(MockitoJUnitRunner.class)
class ActivationReportServiceImplTest {

	private static final String EXISTS = "Exists";

	private static final String NOT_EXISTS = "Not Exists";

	@Mock
	private ActivationReportDaoImpl dao;

	private ActivationReportServiceImpl service = Mockito.mock(ActivationReportServiceImpl.class);

	private ActivationReport entity;

	private ActivationReportDto dto;

	private int trId;

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
		trId = 1;
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
	 * {@link com.comviva.col.service.ActivationReportServiceImpl#addActivationReport(com.comviva.col.entity.ActivationReport)}.
	 * 
	 * @throws DuplicateException
	 */
	@Test
	final void testAddActivationReport_Success() throws DuplicateException {
		when(service.addActivationReport(entity)).thenReturn(entity);
		assertEquals(entity, service.addActivationReport(entity));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.ActivationReportServiceImpl#addActivationReport(com.comviva.col.entity.ActivationReport)}.
	 * 
	 */
	@Test
	final void testAddActivationReport_Failure() {
		try {
			when(service.addActivationReport(entity)).thenThrow(new DuplicateException(EXISTS));
			service.addActivationReport(entity);
			fail("failure");
		} catch (DuplicateException e) {
			assertEquals(EXISTS, e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.ActivationReportServiceImpl#deleteActivationReport(int)}.
	 * 
	 * @throws NotFoundException
	 */
	@Test
	final void testDeleteActivationReport_Success() throws NotFoundException {
		when(service.deleteActivationReport(trId)).thenReturn("DELETED");
		assertEquals("DELETED", service.deleteActivationReport(trId));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.ActivationReportServiceImpl#deleteActivationReport(int)}.
	 */
	@Test
	final void testDeleteActivationReport_Failure() {
		try {
			when(service.deleteActivationReport(trId)).thenThrow(new NotFoundException(NOT_EXISTS));
			service.deleteActivationReport(trId);
			fail("Failure");
		} catch (NotFoundException e) {
			assertEquals(NOT_EXISTS, e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.ActivationReportServiceImpl#viewActivationReport(int)}.
	 * 
	 * @throws NotFoundException
	 */
	@Test
	final void testViewActivationReport_Success() throws NotFoundException {
		when(service.viewActivationReport(trId)).thenReturn(entity);
		assertEquals(entity, service.viewActivationReport(trId));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.ActivationReportServiceImpl#viewActivationReport(int)}.
	 */
	@Test
	final void testViewActivationReport_Failure() {
		try {
			when(service.viewActivationReport(trId)).thenThrow(new NotFoundException(NOT_EXISTS));
			service.viewActivationReport(trId);
			fail("Failure");
		} catch (NotFoundException e) {
			assertEquals(NOT_EXISTS, e.getMessage());
		}

	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.ActivationReportServiceImpl#viewByFromAndToDate(java.time.LocalDate, java.time.LocalDate, java.lang.String)}.
	 * 
	 * @throws NotFoundException
	 */
	@Test
	final void testViewByFromAndToDate_Success() throws NotFoundException {
		when(service.viewByFromAndToDate(from, to, agentCode)).thenReturn(listEntity);
		assertEquals(listEntity, service.viewByFromAndToDate(from, to, agentCode));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.ActivationReportServiceImpl#viewByFromAndToDate(java.time.LocalDate, java.time.LocalDate, java.lang.String)}.
	 * 
	 */
	@Test
	final void testViewByFromAndToDate_Failure() {
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
		when(service.addAllActivationReport(listDto)).thenReturn(listEntity);
		assertEquals(listEntity, service.addAllActivationReport(listDto));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.ActivationReportServiceImpl#viewByMonth(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testViewByMonth() {
		when(service.viewByMonth(month, agentCode)).thenReturn(listEntity);
		assertEquals(listEntity, service.viewByMonth(month, agentCode));

	}

}
