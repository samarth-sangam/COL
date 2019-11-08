/**
 * 
 */
package com.comviva.col.utils.mapper;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * @author samarth.sangam
 *
 */
class ActivationReportMapperTest {

	private ActivationReportMapper mapper = Mockito.mock(ActivationReportMapper.class);

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.utils.mapper.ActivationReportMapper#toEntity(com.comviva.col.utils.dto.ActivationReportDto)}.
	 */
	@Test
	final void testToEntity() {
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.utils.mapper.ActivationReportMapper#toDTO(com.comviva.col.entity.ActivationReport)}.
	 */
	@Test
	final void testToDTO() {
		fail("Not yet implemented");
	}

}
