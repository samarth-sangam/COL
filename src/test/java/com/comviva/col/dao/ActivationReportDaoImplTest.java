/**
 * 
 */
package com.comviva.col.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.comviva.col.entity.ActivationReport;
import com.comviva.col.repository.ActivationReportRepository;

/**
 * @author samarth.sangam
 *
 */
@RunWith(MockitoJUnitRunner.class)
class ActivationReportDaoImplTest {

	@Mock
	private ActivationReportRepository repository;

	private ActivationReportDaoImpl dao = Mockito.mock(ActivationReportDaoImpl.class);

	private ActivationReport activationReport;

	private int trId;

	private List<ActivationReport> list = new ArrayList<>();

	private LocalDate from = LocalDate.of(2019, 10, 01);

	private LocalDate to = LocalDate.of(2019, 11, 01);

	private String agentCode = "100";

	private String month = "MARCH";

	@Before
	public void before() {
		activationReport = new ActivationReport();
		trId = 1;
		activationReport.setTrId(1);
		activationReport.setAgentCode("100");
		list.add(activationReport);
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.ActivationReportDaoImpl#addAllActivationReport(java.util.List)}.
	 */
	@Test
	final void testAddAllActivationReport_Success() {
		when(dao.addAllActivationReport(list)).thenReturn(list);
		assertEquals(list.size(), dao.addAllActivationReport(list).size());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.ActivationReportDaoImpl#viewByFromAndToDate(java.time.LocalDate, java.time.LocalDate, java.lang.String)}.
	 */
	@Test
	final void testViewByFromAndToDateLocalDateLocalDateString() {
		when(dao.viewByFromAndToDate(from, to, agentCode)).thenReturn(list);
		assertEquals(list.size(), dao.viewByFromAndToDate(from, to, agentCode).size());
	}

}
