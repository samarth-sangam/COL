package com.comviva.col.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comviva.col.service.interfaces.IUserMasterService;
import com.comviva.col.utils.PasswordEncryption;

/**
 * REST apis for Login.
 * 
 * @author samarth.sangam
 *
 */
@RestController
@RequestMapping(value = "/api/v1/login/")
public class LoginRestController {

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
	@PostMapping(value = "/userId")
	public ResponseEntity<?> loginUsingUserId(@RequestParam int userId, @RequestParam String password)
			throws Exception {
		return ResponseEntity.ok(userMasterService.loginUsingUserId(userId, PasswordEncryption.encrypt(password)));

	}

	/**
	 * REST api to login using mobileNumber.
	 * 
	 * @param mobileNumber
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/mobileNumber")
	public ResponseEntity<?> loginUsingMobileNumber(@RequestParam String mobileNumber, @RequestParam String password)
			throws Exception {
		return ResponseEntity.ok(userMasterService.loginUsingMobileNumber(mobileNumber, password));
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
	public ResponseEntity<?> resetPassword(@PathVariable int id, @RequestParam String password) throws Exception {
		return ResponseEntity.ok(userMasterService.resetPassword(id, password));

	}

}
