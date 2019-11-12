package com.comviva.col.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.comviva.col.entity.UserMaster;
import com.comviva.col.exceptions.InvalidPasswordException;
import com.comviva.col.exceptions.NotFoundException;
import com.comviva.col.security.JwtResponse;
import com.comviva.col.service.JwtUserDetailsService;
import com.comviva.col.service.interfaces.IUserMasterService;
import com.comviva.col.utils.JwtTokenUtil;
import com.comviva.col.utils.dto.JwtRequest;

/**
 * JWT Authentication Controller.
 * 
 * @author samarth.sangam
 *
 */
@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	private IUserMasterService userMasterService;

	@PostMapping(value = "/authenticate")
	@CrossOrigin
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		JwtResponse response = getUserId(authenticationRequest, token);

		return ResponseEntity.ok(response);
	}

	/**
	 * Creates Response Object with token and userId.
	 * 
	 * @param authenticationRequest
	 * @param token
	 * @return
	 * @throws NotFoundException
	 * @throws InvalidPasswordException
	 */
	private JwtResponse getUserId(JwtRequest authenticationRequest, final String token)
			throws NotFoundException, InvalidPasswordException {
		JwtResponse response = new JwtResponse(token);

		UserMaster userMaster = userMasterService.loginUsingMobileNumber(authenticationRequest.getUsername(),
				authenticationRequest.getPassword());
		if (userMaster != null) {
			response.setUserId(userMaster.getUserId());
		} else {
			response.setUserId(Integer.parseInt(authenticationRequest.getUsername()));
		}
		return response;
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}