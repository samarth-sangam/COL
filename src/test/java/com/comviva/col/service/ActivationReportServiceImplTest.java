/**
 * 
 */
package com.comviva.col.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.comviva.col.ColApplication;
import com.comviva.col.entity.ActivationReport;
import com.comviva.col.exceptions.NotFoundException;
import com.comviva.col.utils.dto.ActivationReportDto;

/**
 * @author samarth.sangam
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ColApplication.class)
@ActiveProfiles("Test")
class ActivationReportServiceImplTest {

	@Autowired
	private ActivationReportServiceImpl service;

	private ActivationReportDto dto;

	private List<ActivationReportDto> list = new ArrayList<>();

	/**
	 * @throws java.lang.Exception
	 */
	void setUp() {
		dto = new ActivationReportDto();
		dto.setActiType("actiType");
		dto.setActivationDate(LocalDate.now());
		dto.setAgentCode("agentCode");
		dto.setCategory("category");
		dto.setExternalId("externalId");
		dto.setIncentive("incentive");
		dto.setMobileNumber("mobileNumber");
		dto.setMonth("month");
		dto.setName("name");
		dto.setScheme("scheme");
		dto.setStatus('y');
		list.add(dto);
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.ActivationReportServiceImpl#addAllActivationReport(java.util.List)}.
	 */
	@Test
	final void testAddAllActivationReport() {
		this.setUp();
		List<ActivationReport> actual = service.addAllActivationReport(list);
		assertEquals(1, actual.size());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.ActivationReportServiceImpl#viewByFromAndToDate(java.time.LocalDate, java.time.LocalDate, java.lang.String)}.
	 * 
	 * @throws NotFoundException
	 */
	@Test
	final void testViewByFromAndToDate_Success() throws NotFoundException {
		List<ActivationReport> actual = service.viewByFromAndToDate(LocalDate.of(2019, 11, 01),
				LocalDate.of(2019, 11, 20), "agentCode");
		assertEquals(1, actual.size());

	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.ActivationReportServiceImpl#viewByFromAndToDate(java.time.LocalDate, java.time.LocalDate, java.lang.String)}.
	 * 
	 * @throws NotFoundException
	 */
	@Test
	final void testViewByFromAndToDate_Exception() {
		try {
			List<ActivationReport> actual = service.viewByFromAndToDate(LocalDate.of(2019, 10, 01),
					LocalDate.of(2019, 10, 20), "agentCode");
		} catch (NotFoundException e) {
			assertTrue(true);
		}

	}

}
