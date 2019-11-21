/**
 * 
 */
package com.comviva.col.utils.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.comviva.col.entity.UserMaster;
import com.comviva.col.utils.dto.UserMasterDto;

/**
 * @author samarth.sangam
 *
 */
class UserMasterMapperTest {

	private UserMasterMapper mapper = new UserMasterMapper();

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
		entity.setEmail("email");
		entity.setLocation("location");
		entity.setParentId(1);
		entity.setPassword("password");
		entity.setType("type");
		entity.setUsername("username");

		dto.setMobileNumber(mobileNumber);
		dto.setEmail("email");
		dto.setLocation("location");
		dto.setParentId(1);
		dto.setPassword("password");
		dto.setType("type");
		dto.setUsername("username");

	}

	/**
	 * Test method for
	 * {@link com.comviva.col.utils.mapper.UserMasterMapper#toEntity(com.comviva.col.utils.dto.UserMasterDto)}.
	 */
	@Test
	final void testToEntityUserMasterDto() {
		UserMaster actual = mapper.toEntity(dto);
		assertEquals(entity.getEmail(), actual.getEmail());
		assertEquals(entity.getLocation(), actual.getLocation());
		assertEquals(entity.getMobileNumber(), actual.getMobileNumber());
		assertEquals(entity.getParentId(), actual.getParentId());
		assertEquals(entity.getPassword(), actual.getPassword());
		assertEquals(entity.getType(), actual.getType());
		assertEquals(entity.getUsername(), actual.getUsername());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.utils.mapper.UserMasterMapper#toDto(com.comviva.col.entity.UserMaster)}.
	 */
	@Test
	final void testToDto() {
		UserMasterDto actual = mapper.toDto(entity);
		assertEquals(dto.getEmail(), actual.getEmail());
		assertEquals(dto.getLocation(), actual.getLocation());
		assertEquals(dto.getMobileNumber(), actual.getMobileNumber());
		assertEquals(dto.getParentId(), actual.getParentId());
		assertEquals(dto.getPassword(), actual.getPassword());
		assertEquals(dto.getType(), actual.getType());
		assertEquals(dto.getUsername(), actual.getUsername());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.utils.mapper.UserMasterMapper#toEntity(com.comviva.col.utils.dto.UserMasterDto, int)}.
	 */
	@Test
	final void testToEntityUserMasterDtoInt() {
		UserMaster actual = mapper.toEntity(dto, userId);
		assertEquals(entity.getEmail(), actual.getEmail());
		assertEquals(entity.getLocation(), actual.getLocation());
		assertEquals(entity.getMobileNumber(), actual.getMobileNumber());
		assertEquals(entity.getParentId(), actual.getParentId());
		assertEquals(entity.getPassword(), actual.getPassword());
		assertEquals(entity.getType(), actual.getType());
		assertEquals(entity.getUsername(), actual.getUsername());
		assertEquals(userId, actual.getUserId());
	}

}
