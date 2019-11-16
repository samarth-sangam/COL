/**
 * 
 */
package com.comviva.col.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.comviva.col.entity.ActivationReport;
import com.comviva.col.repository.ActivationReportRepository;

/**
 * @author samarth.sangam
 *
 */
@RunWith(MockitoJUnitRunner.class)
class ActivationReportDaoImplMockitoTest {

	private ActivationReportRepository repository = Mockito.mock(ActivationReportRepository.class);

	@MockBean
	private AbstractDaoImpl<ActivationReport> abstractDao = Mockito.mock(AbstractDaoImpl.class);

	private ActivationReportDaoImpl dao = Mockito.mock(ActivationReportDaoImpl.class);

	private ActivationReport activationReport;

	private int trId;

	private List<ActivationReport> requestList = new ArrayList<>();

	private List<ActivationReport> list = new ArrayList<>();

	private LocalDate from = LocalDate.of(2019, 10, 01);

	private LocalDate to = LocalDate.of(2019, 11, 01);

	private String agentCode = "100";

	private String month = "MARCH";

	@BeforeEach
	public void before() {
		activationReport = new ActivationReport();
		trId = 1;
		activationReport.setAgentCode("100");
		requestList.add(activationReport);
		activationReport.setTrId(1);
		list.add(activationReport);
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.ActivationReportDaoImpl#addAllActivationReport(java.util.List)}.
	 */
	@Test
	final void testAddAllActivationReport_Return_Type_Success() {
		when(dao.addAllActivationReport(requestList)).thenReturn(requestList);
		assertEquals(requestList.size(), dao.addAllActivationReport(requestList).size());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.ActivationReportDaoImpl#addAllActivationReport(java.util.List)}.
	 */
	@Test
	final void testAddAllActivationReport_Success() {
		when(repository.saveAll(requestList)).thenReturn(list);
		assertEquals(0, dao.addAllActivationReport(requestList).size());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.ActivationReportDaoImpl#viewByFromAndToDate(java.time.LocalDate, java.time.LocalDate, java.lang.String)}.
	 */
	@Test
	final void testViewByFromAndToDateLocalDateLocalDateString_Return_Type() {
		when(dao.viewByFromAndToDate(from, to, agentCode)).thenReturn(requestList);
		assertEquals(requestList.size(), dao.viewByFromAndToDate(from, to, agentCode).size());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.ActivationReportDaoImpl#viewByFromAndToDate(java.time.LocalDate, java.time.LocalDate, java.lang.String)}.
	 */
	@Test
	final void testViewByFromAndToDateLocalDateLocalDateString() {
		when(abstractDao.viewByFromAndToDate(from, to, agentCode, "col_activation_report")).thenReturn(requestList);
		assertEquals(0, dao.viewByFromAndToDate(from, to, agentCode).size());
	}

}
