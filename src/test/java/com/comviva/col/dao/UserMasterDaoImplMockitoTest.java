/**
 * 
 */
package com.comviva.col.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.comviva.col.entity.UserMaster;
import com.comviva.col.repository.UserMasterRepository;

/**
 * @author samarth.sangam
 *
 */
@RunWith(MockitoJUnitRunner.class)
class UserMasterDaoImplMockitoTest {

	private UserMasterRepository repository = Mockito.mock(UserMasterRepository.class);

	private UserMasterDaoImpl dao = Mockito.mock(UserMasterDaoImpl.class);

	private UserMaster userMaster;

	private int userId = 1;

	private List<UserMaster> list = new ArrayList<>();

	private int parentId = 100;

	private String type = "ADMIN";

	private String mobileNumber = "9999999999";

	@BeforeEach
	public void before() {
		userMaster = new UserMaster();
		userMaster.setParentId(parentId);
		userMaster.setMobileNumber(mobileNumber);
		userMaster.setType(type);
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
		when(dao.addUserMaster(userMaster)).thenReturn(userMaster);
		assertEquals(userMaster, dao.addUserMaster(userMaster));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.UserMasterDaoImpl#addUserMaster(com.comviva.col.entity.UserMaster)}.
	 * 
	 * @throws Exception
	 */
	@Test
	final void testAddUserMaster_Failure() {
		try {
			when(dao.addUserMaster(userMaster)).thenThrow(new Exception("Exists"));
			dao.addUserMaster(userMaster);
		} catch (Exception e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.UserMasterDaoImpl#viewUserMaster(int)}.
	 */
	@Test
	final void testViewUserMaster_Success() {
		when(repository.save(userMaster)).thenReturn(userMaster);
		assertEquals(null, dao.viewUserMaster(userId));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.UserMasterDaoImpl#viewUserMaster(int)}.
	 */
	@Test
	final void testViewUserMaster_Failure() {
		when(dao.viewUserMaster(1)).thenReturn(null);
		assertNull(dao.viewUserMaster(userId));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.UserMasterDaoImpl#updateUserMaster(com.comviva.col.entity.UserMaster)}.
	 * 
	 * @throws Exception
	 */
	@Test
	final void testUpdateUserMaster_Success() throws Exception {
		when(dao.updateUserMaster(userMaster, userId)).thenReturn(userMaster);
		assertEquals(userMaster, dao.updateUserMaster(userMaster, userId));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.UserMasterDaoImpl#updateUserMaster(com.comviva.col.entity.UserMaster)}.
	 * 
	 * @throws Exception
	 */
	@Test
	final void testUpdateUserMaster_Failure() {
		try {
			when(dao.updateUserMaster(userMaster, userId)).thenThrow(new Exception("Not Exists"));
			dao.updateUserMaster(userMaster, userId);
		} catch (Exception e) {
			assertNotNull(e);
			return;
		}
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.UserMasterDaoImpl#deleteUserMaster(int)}.
	 */
	@Test
	final void testDeleteUserMaster_Success() {
		when(dao.deleteUserMaster(userId)).thenReturn(true);
		assertTrue(dao.deleteUserMaster(userId));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.UserMasterDaoImpl#deleteUserMaster(int)}.
	 */
	@Test
	final void testDeleteUserMaster_Failure() {
		when(dao.deleteUserMaster(userId)).thenReturn(false);
		assertFalse(dao.deleteUserMaster(userId));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.UserMasterDaoImpl#viewAllByType(int)}.
	 */
	@Test
	final void testViewAllByType_Success() {
		when(dao.viewAllByType(type)).thenReturn(list);
		assertEquals(list.size(), dao.viewAllByType(type).size());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.UserMasterDaoImpl#getByMobileNumber(java.lang.String)}.
	 */
	@Test
	final void testGetByMobileNumber_Success() {
		when(dao.getByMobileNumber(mobileNumber)).thenReturn(userMaster);
		assertEquals(userMaster, dao.getByMobileNumber(mobileNumber));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.UserMasterDaoImpl#getByMobileNumber(java.lang.String)}.
	 */
	@Test
	final void testGetByMobileNumber_Failure() {
		when(dao.getByMobileNumber(mobileNumber)).thenReturn(null);
		assertNull(dao.getByMobileNumber(mobileNumber));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.UserMasterDaoImpl#updateWithoutCheckingForUserMaster(com.comviva.col.entity.UserMaster)}.
	 */
	@Test
	final void testUpdateWithoutCheckingForUserMaster() {
		when(dao.updateWithoutCheckingForUserMaster(userMaster)).thenReturn(userMaster);
		assertEquals(userMaster, dao.updateWithoutCheckingForUserMaster(userMaster));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.dao.UserMasterDaoImpl#viewAllByByParentId(int)}.
	 */
	@Test
	final void testViewAllByByParentId() {
		when(dao.viewAllByByParentId(parentId)).thenReturn(list);
		assertEquals(list.size(), dao.viewAllByByParentId(parentId).size());
	}

}
