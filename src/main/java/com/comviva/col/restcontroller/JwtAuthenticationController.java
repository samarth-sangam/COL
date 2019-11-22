package com.comviva.col.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.comviva.col.entity.UserMaster;
import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.InvalidPasswordException;
import com.comviva.col.exceptions.NotFoundException;
import com.comviva.col.exceptions.UnauthorizedException;
import com.comviva.col.repository.AuthUserRepository;
import com.comviva.col.service.JwtUserDetailsService;
import com.comviva.col.service.interfaces.IUserMasterService;
import com.comviva.col.utils.JwtTokenUtil;
import com.comviva.col.utils.dto.JwtRequest;
import com.comviva.col.utils.dto.UserMasterDto;
import com.comviva.col.utils.mapper.UserMasterMapper;
import com.comviva.col.utils.responseobjects.JwtResponse;

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

	private UserMasterMapper mapper = new UserMasterMapper();

	@Autowired
	private AuthUserRepository repository;

	/**
	 * REST api to authenticate and create JWT Token.
	 * 
	 * @param authenticationRequest
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/authenticate")
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(getUser(authenticationRequest, token));
	}

	/**
	 * Creates Response Object.
	 * 
	 * @param authenticationRequest
	 * @param token
	 * @return
	 * @throws NotFoundException
	 * @throws InvalidPasswordException
	 */
	private JwtResponse getUser(JwtRequest authenticationRequest, final String token)
			throws NotFoundException, InvalidPasswordException {

		UserMaster userMaster = userMasterService.loginUsingMobileNumber(authenticationRequest.getUsername(),
				authenticationRequest.getPassword());

		JwtResponse response = new JwtResponse(token);

		if (userMaster == null) {
			userMaster = userMasterService.loginUsingUserId(Integer.parseInt(authenticationRequest.getUsername()),
					authenticationRequest.getPassword());
		}

		response.setUserId(userMaster.getUserId());
		response.setType(userMaster.getType());
		response.setPasswordChangeDate(userMaster.getPasswordChangeDate());
		response.setLocation(userMaster.getLocation());
		response.setUsername(userMaster.getUsername());
		response.setEmail(userMaster.getEmail());
		return response;
	}

	/**
	 * Authenticate JWT.
	 * 
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception(e);
		} catch (BadCredentialsException e) {
			throw new Exception(e);
		}
	}

	@PostMapping(value = "/register")
	public ResponseEntity<?> saveUser(@RequestBody UserMasterDto user)
			throws UnauthorizedException, DuplicateException {
		if (repository.existsByRole("ADMIN")) {
			throw new UnauthorizedException("ADMIN exists, Cannot create anymore Admin");
		}
		return ResponseEntity.ok(userMasterService.addUserMaster(mapper.toEntity(user)));
	}

	@GetMapping(value = "/hello")
	public String hello() {
		return "Hello Https";
	}

}