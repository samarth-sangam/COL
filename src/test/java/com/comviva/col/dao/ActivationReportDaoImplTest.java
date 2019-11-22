/**
 * 
 */
package com.comviva.col.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.comviva.col.ColApplication;
import com.comviva.col.entity.ActivationReport;

/**
 * @author samarth.sangam
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ColApplication.class)
@ActiveProfiles("Test")
class ActivationReportDaoImplTest {

	@Autowired
	private ActivationReportDaoImpl dao;

	private ActivationReport activationReport;

	private List<ActivationReport> list;

	/**
	 * @throws java.lang.Exception
	 */
	void set() throws Exception {
		activationReport = new ActivationReport();
		activationReport.setTrId(UUID.randomUUID().toString());
		activationReport.setActiType("actiType");
		activationReport.setActivationDate(LocalDateTime.now());
		activationReport.setAgentCode("1");
		activationReport.setAmount("1000");
		activationReport.setCategory("category");
		activationReport.setExternalId("externalId");
		activationReport.setIncentive("incentive");
		activationReport.setMobileNumber("mobileNumber");
		activationReport.setMonth("month");
		activationReport.setName("name");
		activationReport.setScheme("scheme");
		activationReport.setStatus(new Character('Y'));
		list = new ArrayList<>();
		list.add(activationReport);

	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.ActivationReportDaoImpl#addAllActivationReport(java.util.List)}.
	 * 
	 * @throws Exception
	 */
	@Test
	final void testAddAllActivationReport() throws Exception {
		this.set();

	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.ActivationReportDaoImpl#viewByFromAndToDate(java.time.LocalDate, java.time.LocalDate, java.lang.String)}.
	 */
	@Test
	final void testViewByFromAndToDateLocalDateLocalDateString() {

	}

}
