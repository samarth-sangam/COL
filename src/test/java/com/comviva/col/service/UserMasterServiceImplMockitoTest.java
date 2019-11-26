/**
 * 
 */
package com.comviva.col.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.comviva.col.dao.UserMasterDaoImpl;
import com.comviva.col.entity.UserMaster;
import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.InvalidPasswordException;
import com.comviva.col.exceptions.NotFoundException;

/**
 * @author samarth.sangam
 *
 */
@RunWith(MockitoJUnitRunner.class)
class UserMasterServiceImplMockitoTest {

	private static final String NOT_EXISTS = "Not Exists";

	private static final String INVALID_PASSWORD = "Invalid Password";

	private static final String EXISTS = "Exists";

	@Mock
	private UserMasterDaoImpl dao;

	private UserMasterServiceImpl service = Mockito.mock(UserMasterServiceImpl.class);

	private UserMaster userMaster;

	private int userId;

	private int parentId;

	private List<UserMaster> list = new ArrayList<>();

	private String type = "ADMIN";

	private String password = "password";

	private String mobileNumber = "9999999999";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		userMaster = new UserMaster();
		userMaster.setUserId(userId);
		userMaster.setParentId(parentId);
		list.add(userMaster);
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#addUserMaster(com.comviva.col.entity.UserMaster)}.
	 * 
	 * @throws DuplicateException
	 */
	@Test
	final void testAddUserMaster_Success() throws DuplicateException {
		when(service.addUserMaster(userMaster)).thenReturn(userMaster);
		assertEquals(userMaster, service.addUserMaster(userMaster));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#addUserMaster(com.comviva.col.entity.UserMaster)}.
	 * 
	 */
	@Test
	final void testAddUserMaster_Failure() {
		try {
			when(service.addUserMaster(userMaster)).thenThrow(new DuplicateException(EXISTS));
			service.addUserMaster(userMaster);
			fail("failure");
		} catch (DuplicateException e) {
			assertEquals(EXISTS, e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#viewUserMaster(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	final void testViewUserMaster_Success() throws Exception {
		when(service.viewUserMaster(userId)).thenReturn(userMaster);
		assertEquals(userMaster, service.viewUserMaster(userId));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#viewUserMaster(int)}.
	 */
	@Test
	final void testViewUserMaster_Failure_Password() {
		try {
			when(service.viewUserMaster(userId)).thenThrow(new InvalidPasswordException(INVALID_PASSWORD));
			service.viewUserMaster(userId);
			fail("failure");
		} catch (NotFoundException e) {
			fail("failure");
		} catch (InvalidPasswordException e) {
			assertEquals(INVALID_PASSWORD, e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#viewUserMaster(int)}.
	 */
	@Test
	final void testViewUserMaster_Failure_NotFound() {
		try {
			when(service.viewUserMaster(userId)).thenThrow(new NotFoundException(NOT_EXISTS));
			service.viewUserMaster(userId);
			fail("failure");
		} catch (NotFoundException e) {
			assertEquals(NOT_EXISTS, e.getMessage());
		} catch (InvalidPasswordException e) {
			fail("failure");
		}
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#viewAllByTypeUserMaster(java.lang.String)}.
	 * 
	 */
	@Test
	final void testViewAllByTypeUserMaster_Failure() {
		try {
			when(service.viewAllByTypeUserMaster(type)).thenThrow(new NotFoundException(NOT_EXISTS));
			service.viewAllByTypeUserMaster(type);
			fail("Failure");
		} catch (NotFoundException e) {
			assertEquals(NOT_EXISTS, e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#viewAllByTypeUserMaster(java.lang.String)}.
	 * 
	 * @throws NotFoundException
	 */
	@Test
	final void testViewAllByTypeUserMaster_Success() throws NotFoundException {
		when(service.viewAllByTypeUserMaster(type)).thenReturn(list);
		assertEquals(list.size(), service.viewAllByTypeUserMaster(type).size());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#updateUserMaster(com.comviva.col.entity.UserMaster)}.
	 * 
	 * @throws NotFoundException
	 */
	@Test
	final void testUpdateUserMaster_Success() throws NotFoundException {
		when(service.updateUserMaster(userMaster, userId)).thenReturn(userMaster);
		assertEquals(userMaster, service.updateUserMaster(userMaster, userId));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#updateUserMaster(com.comviva.col.entity.UserMaster)}.
	 * 
	 */
	@Test
	final void testUpdateUserMaster_Failure() {
		try {
			when(service.updateUserMaster(userMaster, userId)).thenThrow(new NotFoundException(NOT_EXISTS));
			service.updateUserMaster(userMaster, userId);
			fail("failure");
		} catch (NotFoundException e) {
			assertEquals(NOT_EXISTS, e.getMessage());
		}

	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#loginUsingUserId(int, java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	final void testLoginUsingUserId_Success() throws Exception {
		when(service.loginUsingUserId(userId, password)).thenReturn(userMaster);
		assertEquals(userMaster, service.loginUsingUserId(userId, password));

	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#loginUsingUserId(int, java.lang.String)}.
	 * 
	 */
	@Test
	final void testLoginUsingUserId_Failure_Password() {
		try {
			when(service.loginUsingUserId(userId, password)).thenThrow(new InvalidPasswordException(INVALID_PASSWORD));
			service.loginUsingUserId(userId, password);
			fail("failure");
		} catch (NotFoundException e) {
			fail("failure");
		} catch (InvalidPasswordException e) {
			assertEquals(INVALID_PASSWORD, e.getMessage());
		}

	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#loginUsingUserId(int, java.lang.String)}.
	 * 
	 */
	@Test
	final void testLoginUsingUserId_Failure_NotFound() {
		try {
			when(service.loginUsingUserId(userId, password)).thenThrow(new NotFoundException(NOT_EXISTS));
			service.loginUsingUserId(userId, password);
			fail("failure");
		} catch (NotFoundException e) {
			assertEquals(NOT_EXISTS, e.getMessage());
		} catch (InvalidPasswordException e) {
			fail("failure");
		}

	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#resetPassword(int, java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	final void testResetPassword() throws Exception {
		when(service.resetPassword(userId, password)).thenReturn(userMaster);
		assertEquals(userMaster, service.resetPassword(userId, password));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#loginUsingMobileNumber(java.lang.String, java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	final void testLoginUsingMobileNumber_Success() throws Exception {
		when(service.loginUsingMobileNumber(mobileNumber, password)).thenReturn(userMaster);
		assertEquals(userMaster, service.loginUsingMobileNumber(mobileNumber, password));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#loginUsingMobileNumber(java.lang.String, java.lang.String)}.
	 * 
	 */
	@Test
	final void testLoginUsingMobileNumber_Failure_Password() {
		try {
			when(service.loginUsingMobileNumber(mobileNumber, password))
					.thenThrow(new InvalidPasswordException(INVALID_PASSWORD));
			service.loginUsingMobileNumber(mobileNumber, password);
			fail("failure");
		} catch (NotFoundException e) {
			fail("failure");
		} catch (InvalidPasswordException e) {
			assertEquals(INVALID_PASSWORD, e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#loginUsingMobileNumber(java.lang.String, java.lang.String)}.
	 * 
	 */
	@Test
	final void testLoginUsingMobileNumber_Failure_NotFound() {
		try {
			when(service.loginUsingMobileNumber(mobileNumber, password)).thenThrow(new NotFoundException(NOT_EXISTS));
			service.loginUsingMobileNumber(mobileNumber, password);
			fail("failure");
		} catch (NotFoundException e) {
			assertEquals(NOT_EXISTS, e.getMessage());
		} catch (InvalidPasswordException e) {
			fail("failure");
		}
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#viewAllByParentId(int)}.
	 * 
	 * @throws NotFoundException
	 */
	@Test
	final void testViewAllByParentId_Success() throws NotFoundException {
		when(service.viewAllByParentId(parentId)).thenReturn(list);
		assertEquals(list, service.viewAllByParentId(parentId));
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#viewAllByParentId(int)}.
	 * 
	 */
	@Test
	final void testViewAllByParentId_Failure() {
		try {
			when(service.viewAllByParentId(parentId)).thenThrow(new NotFoundException(NOT_EXISTS));
			service.viewAllByParentId(parentId);
			fail("failure");
		} catch (NotFoundException e) {
			assertEquals(NOT_EXISTS, e.getMessage());
		}
	}

}
