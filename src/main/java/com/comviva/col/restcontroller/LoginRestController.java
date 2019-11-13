package com.comviva.col.restcontroller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comviva.col.service.interfaces.IUserMasterService;

/**
 * REST apis for Login Related.
 * 
 * @author samarth.sangam, mahendra.prajapati
 *
 */
@RestController
@RequestMapping(value = "/api/v1/login/")
@CrossOrigin
public class LoginRestController {

	@Autowired
	private IUserMasterService userMasterService;

	private Logger log = Logger.getLogger(LoginRestController.class);

	/**
	 * REST api to Reset Password.
	 * 
	 * @param id
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "{id}/resetPassword")
	@CrossOrigin
	public ResponseEntity<?> resetPassword(@PathVariable int id, @RequestParam String password) throws Exception {
		log.info("Url pattern /api/v1/login/" + id + "/resetPassword invoked for resetting the password");
		return ResponseEntity.ok(userMasterService.resetPassword(id, password));

	}

}
