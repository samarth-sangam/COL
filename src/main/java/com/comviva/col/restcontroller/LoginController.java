package com.comviva.col.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comviva.col.entity.UserMaster;
import com.comviva.col.service.interfaces.IUserMasterService;
import com.comviva.col.utils.PasswordEncryption;

/**
 * REST apis for Login.
 * 
 * @author samarth.sangam
 *
 */
@RestController
public class LoginController {

	@Autowired
	private IUserMasterService userMasterService;

	/**
	 * REST api to login using UserId.
	 * 
	 * @param userId
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/loginUsingUserId")
	public UserMaster loginUsingUserId(@RequestParam int userId, @RequestParam String password) throws Exception {
		return userMasterService.loginUsingUserId(userId, PasswordEncryption.encrypt(password));
	}

	/**
	 * REST api to login using mobileNumber.
	 * 
	 * @param mobileNumber
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/loginUsingMobileNumber")
	public UserMaster loginUsingMobileNumber(@RequestParam String mobileNumber, @RequestParam String password)
			throws Exception {
		return userMasterService.loginUsingMobileNumber(mobileNumber, password);
	}

	/**
	 * REST api to Reset Password.
	 * 
	 * @param id
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/{id}/resetPassword")
	public UserMaster resetPassword(@PathVariable int id, @RequestParam String password) throws Exception {
		return userMasterService.resetPassword(id, password);

	}

}
