/**
 * 
 */
package com.comviva.col.utils.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.comviva.col.entity.UserMaster;
import com.comviva.col.utils.dto.UserMasterDto;

/**
 * @author samarth.sangam
 *
 */
@RunWith(MockitoJUnitRunner.class)
class UserMasterMapperTest {

	private UserMasterMapper mapper = Mockito.mock(UserMasterMapper.class);

	private UserMaster entity = new UserMaster();

	private UserMasterDto dto = new UserMasterDto();

	private int userId = 100;

	private String mobileNumber = "9999999999";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		entity.setUserId(userId);
		entity.setMobileNumber(mobileNumber);
		dto.setMobileNumber(mobileNumber);

	}

	/**
	 * Test method for
	 * {@link com.comviva.col.utils.mapper.UserMasterMapper#toEntity(com.comviva.col.utils.dto.UserMasterDto)}.
	 */
	@Test
	final void testToEntityUserMasterDto() {
		when(mapper.toEntity(dto)).thenReturn(entity);
		assertEquals(entity, mapper.toEntity(dto));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.utils.mapper.UserMasterMapper#toDto(com.comviva.col.entity.UserMaster)}.
	 */
	@Test
	final void testToDto() {
		when(mapper.toDto(entity)).thenReturn(dto);
		assertEquals(dto, mapper.toDto(entity));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.utils.mapper.UserMasterMapper#toEntity(com.comviva.col.utils.dto.UserMasterDto, int)}.
	 */
	@Test
	final void testToEntityUserMasterDtoInt() {
		when(mapper.toEntity(dto, userId)).thenReturn(entity);
		assertEquals(entity, mapper.toEntity(dto, userId));
	}

}
