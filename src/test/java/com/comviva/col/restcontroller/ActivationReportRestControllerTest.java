/**
 * 
 */
package com.comviva.col.restcontroller;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.comviva.col.entity.ActivationReport;
import com.comviva.col.service.ActivationReportServiceImpl;
import com.comviva.col.utils.dto.ActivationReportDto;
import com.comviva.col.utils.mapper.ActivationReportMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author samarth.sangam
 *
 */
@WebMvcTest
class ActivationReportRestControllerTest {

	private String URL = "localhost:8080/api/v1/activationReport/";

	@Mock
	private ActivationReportServiceImpl service;

	@Mock
	private ActivationReportMapper mapper;

	@Autowired
	private MockMvc mvc;

	private ActivationReportDto dto = new ActivationReportDto();

	private static final String FILENAME = "filename.csv";

	private ActivationReport entity = new ActivationReport();

	private LocalDate from = LocalDate.of(2019, 10, 01);

	private LocalDate to = LocalDate.of(2019, 11, 01);

	private String agentCode = "100";

	private int trId = 1;

	private ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		entity.setTrId(trId);
		entity.setAgentCode(agentCode);
		dto.setAgentCode(agentCode);
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.restcontroller.ActivationReportRestController#addActivationReport(com.comviva.col.utils.dto.ActivationReportDto)}.
	 */
	@Test
	final void testAddActivationReport() {
		// MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri))
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.restcontroller.ActivationReportRestController#addAllActivationReport(java.lang.String)}.
	 */
	@Test
	final void testAddAllActivationReport() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.restcontroller.ActivationReportRestController#viewActivationReportFromAndToDate(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testViewActivationReportFromAndToDate() {
		fail("Not yet implemented");
	}

}
