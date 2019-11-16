/**
 * 
 */
package com.comviva.col.service;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.comviva.col.entity.UserMaster;

/**
 * @author samarth.sangam
 *
 */
class UserMasterServiceImplTest {

	@Autowired
	private UserMasterServiceImpl service;

	private UserMaster userMaster;

	/**
	 * @throws java.lang.Exception
	 */
	void setUp() {
		userMaster = new UserMaster();
		userMaster.setEmail("email");
		userMaster.setLocation("location");
		userMaster.setMobileNumber("mobileNumber");
		userMaster.setParentId(12);
		userMaster.setPassword("password");
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#addUserMaster(com.comviva.col.entity.UserMaster)}.
	 */
	@Test
	final void testAddUserMaster() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#addAllUserMaster(java.util.List)}.
	 */
	@Test
	final void testAddAllUserMaster() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#viewUserMaster(int)}.
	 */
	@Test
	final void testViewUserMaster() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#viewAllByTypeUserMaster(java.lang.String)}.
	 */
	@Test
	final void testViewAllByTypeUserMaster() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#updateUserMaster(com.comviva.col.entity.UserMaster)}.
	 */
	@Test
	final void testUpdateUserMaster() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#loginUsingUserId(int, java.lang.String)}.
	 */
	@Test
	final void testLoginUsingUserId() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#resetPassword(int, java.lang.String)}.
	 */
	@Test
	final void testResetPassword() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#loginUsingMobileNumber(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testLoginUsingMobileNumber() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#viewAllByParentId(int)}.
	 */
	@Test
	final void testViewAllByParentId() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.comviva.col.service.UserMasterServiceImpl#viewByIdWithoutCheckingPassword(int)}.
	 */
	@Test
	final void testViewByIdWithoutCheckingPassword() {
		fail("Not yet implemented");
	}

}
