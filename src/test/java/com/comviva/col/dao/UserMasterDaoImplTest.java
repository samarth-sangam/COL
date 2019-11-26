/**
 * 
 */
package com.comviva.col.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.comviva.col.ColApplication;
import com.comviva.col.entity.UserMaster;

/**
 * @author samarth.sangam
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ColApplication.class)
@ActiveProfiles("Test")
class UserMasterDaoImplTest {

	@Autowired
	private UserMasterDaoImpl dao;

	private UserMaster userMaster;

	private List<UserMaster> list = new ArrayList<>();

	private int userId = 1;

	/**
	 * @throws java.lang.Exception
	 */
	void setUp() {
		userMaster = new UserMaster();
		userMaster.setEmail("email");
		userMaster.setLocation("location");
		userMaster.setMobileNumber("mobileNumber");
		userMaster.setParentId(2);
		userMaster.setPassword("password");
		userMaster.setPasswordChangeDate(LocalDateTime.now());
		userMaster.setType("type");
		userMaster.setUsername("username");
		userMaster.setUserId(userId);
		list.add(userMaster);
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.UserMasterDaoImpl#addUserMaster(com.comviva.col.entity.UserMaster)}.
	 * 
	 * @throws Exception
	 */
	@Test
	final void testAddUserMaster_Success() throws Exception {
		this.setUp();
		userMaster.setMobileNumber("mobileNumber101");
		UserMaster actual = dao.addUserMaster(userMaster);
		userId = actual.getUserId();
		assertEquals("type", actual.getType());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.UserMasterDaoImpl#addUserMaster(com.comviva.col.entity.UserMaster)}.
	 * 
	 * @throws Exception
	 */
	@Test
	final void testAddUserMaster_Exception() {
		@SuppressWarnings("unused")
		UserMaster actual;
		try {
			actual = dao.addUserMaster(userMaster);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.UserMasterDaoImpl#viewUserMaster(int)}.
	 */
	@Test
	final void testViewUserMaster_Null() {
		assertNull(dao.viewUserMaster(1000));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.UserMasterDaoImpl#updateUserMaster(com.comviva.col.entity.UserMaster)}.
	 * 
	 * @throws Exception
	 */
	@Test
	final void testUpdateUserMaster_Success() throws Exception {
		this.setUp();
		userMaster.setMobileNumber("895186549");
		UserMaster u = dao.addUserMaster(userMaster);
		u.setEmail("email1");
		assertEquals("email1", dao.updateUserMaster(u).getEmail());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.UserMasterDaoImpl#updateUserMaster(com.comviva.col.entity.UserMaster)}.
	 * 
	 * @throws Exception
	 */
	@Test
	final void testUpdateUserMaster_Exception() {
		this.setUp();
		userMaster.setUserId(1000);
		userMaster.setEmail("email1");
		try {
			assertEquals("email1", dao.updateUserMaster(userMaster));
		} catch (Exception e) {
			assertEquals("UserMaster not Found", e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.UserMasterDaoImpl#deleteUserMaster(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	final void testDeleteUserMaster_true() throws Exception {
		this.setUp();
		userMaster.setMobileNumber("989898981");
		UserMaster u = dao.addUserMaster(userMaster);
		assertTrue(dao.deleteUserMaster(u.getUserId()));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.UserMasterDaoImpl#deleteUserMaster(int)}.
	 */
	@Test
	final void testDeleteUserMaster_false() {
		assertFalse(dao.deleteUserMaster(10001));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.UserMasterDaoImpl#viewAllByType(java.lang.String)}.
	 */
	@Test
	final void testViewAllByType() {
		assertNotNull(dao.viewAllByType("type"));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.UserMasterDaoImpl#getByMobileNumber(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	final void testGetByMobileNumber() throws Exception {
		this.setUp();
		userMaster.setMobileNumber("123456789");
		dao.addUserMaster(userMaster);
		assertEquals("123456789", dao.getByMobileNumber("123456789").getMobileNumber());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.UserMasterDaoImpl#updateWithoutCheckingForUserMaster(com.comviva.col.entity.UserMaster)}.
	 * 
	 * @throws Exception
	 */
	@Test
	final void testUpdateWithoutCheckingForUserMaster() throws Exception {
		this.setUp();
		userMaster.setMobileNumber("988695213");
		userMaster.setType("type1");
		UserMaster u = dao.addUserMaster(userMaster);
		u.setType("type");
		assertEquals("type", dao.updateWithoutCheckingForUserMaster(u).getType());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.UserMasterDaoImpl#viewAllByByParentId(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	final void testViewAllByByParentId() throws Exception {
		this.setUp();
		userMaster.setMobileNumber("newMobileNo");
		dao.addUserMaster(userMaster);
		assertEquals(2, dao.viewAllByByParentId(2).get(0).getParentId());
	}

}
