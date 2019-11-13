package com.comviva.col.security;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Login Response Objects.
 * 
 * @author samarth.sangam
 *
 */
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;

	private Integer userId;
	String type;
	LocalDate passwordChangeDate;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getPasswordChangeDate() {
		return passwordChangeDate;
	}

	public void setPasswordChangeDate(LocalDate passwordChangeDate) {
		this.passwordChangeDate = passwordChangeDate;
	}

}