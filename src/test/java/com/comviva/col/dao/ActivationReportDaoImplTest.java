/**
 * 
 */
package com.comviva.col.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
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
	 * {@link com.comviva.col.dao.ActivationReportDaoImpl#addActivationReport(com.comviva.col.entity.ActivationReport)}.
	 * 
	 * @throws Exception
	 */
	@Test
	final void testAddActivationReport_Success() throws Exception {
		when(dao.addActivationReport(activationReport)).thenReturn(activationReport);
		assertEquals(activationReport, dao.addActivationReport(activationReport));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.ActivationReportDaoImpl#addActivationReport(com.comviva.col.entity.ActivationReport)}.
	 * 
	 * @throws Exception
	 */
	@Test
	final void testAddActivationReport_Failure() {
		try {
			when(dao.addActivationReport(activationReport)).thenThrow(new Exception("Exists"));
			dao.addActivationReport(activationReport);
		} catch (Exception e) {
			assertEquals("Exists", e.getMessage());
			return;
		}
		fail("Failure");
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.ActivationReportDaoImpl#viewActivationReport(int)}.
	 */
	@Test
	final void testViewActivationReport_Success() {
		when(dao.viewActivationReport(trId)).thenReturn(activationReport);
		assertEquals(activationReport, dao.viewActivationReport(trId));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.ActivationReportDaoImpl#viewActivationReport(int)}.
	 */
	@Test
	final void testViewActivationReport_Failure() {
		when(dao.viewActivationReport(trId)).thenReturn(null);
		assertNull(dao.viewActivationReport(trId));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.ActivationReportDaoImpl#updateActivationReport(com.comviva.col.entity.ActivationReport)}.
	 * 
	 * @throws Exception
	 */
	@Test
	final void testUpdateActivationReport_Success() throws Exception {
		when(dao.updateActivationReport(activationReport)).thenReturn(activationReport);
		assertEquals(activationReport, dao.updateActivationReport(activationReport));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.ActivationReportDaoImpl#updateActivationReport(com.comviva.col.entity.ActivationReport)}.
	 * 
	 * @throws Exception
	 */
	@Test
	final void testUpdateActivationReport_Failure() {
		try {
			when(dao.updateActivationReport(activationReport)).thenThrow(new Exception("Not Exists"));
			dao.updateActivationReport(activationReport);
		} catch (Exception e) {
			assertEquals("Not Exists", e.getMessage());
			return;
		}
		fail("Failure");
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.ActivationReportDaoImpl#deleteActivationReport(int)}.
	 */
	@Test
	final void testDeleteActivationReport_Success() {
		when(dao.deleteActivationReport(trId)).thenReturn(true);
		assertTrue(dao.deleteActivationReport(trId));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.ActivationReportDaoImpl#deleteActivationReport(int)}.
	 */
	@Test
	final void testDeleteActivationReport_Failure() {
		when(dao.deleteActivationReport(trId)).thenReturn(false);
		assertFalse(dao.deleteActivationReport(trId));
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

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.ActivationReportDaoImpl#viewByMonth(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testViewByMonthStringString() {
		when(dao.viewByMonth(month, agentCode)).thenReturn(list);
		assertEquals(list.size(), dao.viewByMonth(month, agentCode).size());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.ActivationReportDaoImpl#deleteByMonth(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testDeleteByMonthStringString() {
	}

}
