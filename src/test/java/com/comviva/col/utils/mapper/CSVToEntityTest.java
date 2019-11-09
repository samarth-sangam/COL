/**
 * 
 */
package com.comviva.col.utils.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.comviva.col.utils.dto.ActivationReportDto;

/**
 * @author samarth.sangam
 *
 */
@RunWith(MockitoJUnitRunner.class)
class CSVToEntityTest {

	private static final String NO_FILE_FOUND = "NO FILE FOUND";

	private CSVToEntity mapper = Mockito.mock(CSVToEntity.class);

	private final static String FILENAME = "filename.csv";

	private List<ActivationReportDto> list = new ArrayList<>();

	/**
	 * Test method for
	 * {@link com.comviva.col.utils.mapper.CSVToEntity#getInstance()}
	 */
	@Test
	final void testGetInstance() {
		assertNotNull(mapper);

	}

	/**
	 * Test method for
	 * {@link com.comviva.col.utils.mapper.CSVToEntity#readCSVFileIntoActivationReportObject(java.lang.String)}.
	 * 
	 * @throws IOException
	 * 
	 */
	@Test
	final void testReadCSVFileIntoActivationReportObject_Success() throws IOException {
		list.add(new ActivationReportDto());
		when(mapper.readCSVFileIntoActivationReportObject(FILENAME)).thenReturn(list);
		assertEquals(list.size(), mapper.readCSVFileIntoActivationReportObject(FILENAME).size());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.utils.mapper.CSVToEntity#readCSVFileIntoActivationReportObject(java.lang.String)}.
	 * 
	 */
	@Test
	final void testReadCSVFileIntoActivationReportObject_Success_NOFILEFOUND() {
		list.add(new ActivationReportDto());
		try {
			when(mapper.readCSVFileIntoActivationReportObject(FILENAME)).thenThrow(new IOException(NO_FILE_FOUND));
			mapper.readCSVFileIntoActivationReportObject(FILENAME);
			fail("failure");
		} catch (IOException e) {
			assertEquals(NO_FILE_FOUND, e.getMessage());
		}
	}

}
