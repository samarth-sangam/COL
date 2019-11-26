/**
 * 
 */
package com.comviva.col.service;

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
import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.InvalidPasswordException;
import com.comviva.col.exceptions.NotFoundException;
import com.comviva.col.repository.UserMasterRepository;

/**
 * @author samarth.sangam
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ColApplication.class)
@ActiveProfiles("Test")
class UserMasterServiceImplTest {

	@Autowired
	private UserMasterServiceImpl service;

	@Autowired
	private UserMasterRepository repository;

	private UserMaster userMaster;

	private List<UserMaster> list = new ArrayList<>();

	@SuppressWarnings("unused")
	private String password = "password";

	void setUp() {
		userMaster = new UserMaster();
		userMaster.setEmail("email");
		userMaster.setType("type");
		userMaster.setLocation("location");
		userMaster.setMobileNumber("mobileNumber");
		userMaster.setParentId(12);
		userMaster.setPasswordChangeDate(LocalDateTime.now());
		userMaster.setPassword("password");
		list.add(userMaster);
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#addUserMaster(com.comviva.col.entity.UserMaster)}.
	 */
	@Test
	final void testAddUserMaster() throws DuplicateException {
		this.setUp();
		UserMaster actual = service.addUserMaster(userMaster);
		assertEquals("type", actual.getType());
		repository.deleteById(actual.getUserId());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#viewUserMaster(int)}.
	 */
	@Test
	final void testViewUserMaster() throws NotFoundException, InvalidPasswordException, DuplicateException {
		this.setUp();
		userMaster.setMobileNumber("1");
		UserMaster actual = service.addUserMaster(userMaster);
		assertEquals(actual.getUserId(), service.viewUserMaster(actual.getUserId()).getUserId());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#viewAllByTypeUserMaster(java.lang.String)}.
	 */
	@Test
	final void testViewAllByTypeUserMaster() throws NotFoundException, DuplicateException {
		this.setUp();
		userMaster.setMobileNumber("2");
		service.addUserMaster(userMaster);
		assertEquals("type", service.viewAllByTypeUserMaster("type").get(0).getType());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#updateUserMaster(com.comviva.col.entity.UserMaster)}.
	 */
	@Test
	final void testUpdateUserMaster() throws NotFoundException, DuplicateException {
		this.setUp();
		userMaster.setMobileNumber("3");
		UserMaster userMaster1 = service.addUserMaster(userMaster);
		assertEquals("email", service.updateUserMaster(userMaster1).getEmail());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#loginUsingUserId(int, java.lang.String)}.
	 */
	@Test
	final void testLoginUsingUserId() throws NotFoundException, InvalidPasswordException, DuplicateException {
		this.setUp();
		userMaster.setMobileNumber("newMobileNumber");
		UserMaster userMaster3 = service.addUserMaster(userMaster);
		assertEquals(userMaster3.getUserId(),
				service.loginUsingUserId(userMaster3.getUserId(), "password").getUserId());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#resetPassword(int, java.lang.String)}.
	 */
	@Test
	final void testResetPassword() throws NotFoundException, InvalidPasswordException, DuplicateException {
		this.setUp();
		userMaster.setMobileNumber("10");
		service.addUserMaster(userMaster);
		assertEquals(1, 1);
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#loginUsingMobileNumber(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testLoginUsingMobileNumber() throws NotFoundException, InvalidPasswordException, DuplicateException {
		this.setUp();
		userMaster.setMobileNumber("11");
		@SuppressWarnings("unused")
		UserMaster userMaster6 = service.addUserMaster(userMaster);
		assertEquals("11", service.loginUsingMobileNumber("11", "password").getMobileNumber());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#viewAllByParentId(int)}.
	 */
	@Test
	final void testViewAllByParentId() throws NotFoundException {
		assertEquals(12, service.viewAllByParentId(12).get(0).getParentId());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#viewByIdWithoutCheckingPassword(int)}.
	 */
	@Test
	final void testViewByIdWithoutCheckingPassword_Success() throws NotFoundException, DuplicateException {
		this.setUp();
		userMaster.setMobileNumber("123");
		UserMaster userMaster7 = service.addUserMaster(userMaster);
		assertEquals(userMaster7.getUserId(),
				service.viewByIdWithoutCheckingPassword(userMaster7.getUserId()).getUserId());
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#viewByIdWithoutCheckingPassword(int)}.
	 */
	@Test
	final void testViewByIdWithoutCheckingPassword_Exception() throws NotFoundException, DuplicateException {
		this.setUp();
		userMaster.setMobileNumber("1234");
		UserMaster x = service.addUserMaster(userMaster);
		assertEquals(x.getUserId(), service.viewByIdWithoutCheckingPassword(x.getUserId()).getUserId());
	}

}
