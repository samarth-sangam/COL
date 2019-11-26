package com.comviva.col.utils.dto;

import javax.validation.constraints.NotNull;

/**
 * 
 * @author samarth.sangam
 *
 */
public class UserMasterDto {

	@NotNull
	String username;
	String password;
	@NotNull
	String email;
	@NotNull
	String mobileNumber;
	@NotNull
	String type;
	Integer parentId;
	@NotNull
	String location;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "UserMasterDto [username=" + username + ", password=" + password + ", email=" + email + ", mobileNumber="
				+ mobileNumber + ", type=" + type + ", parentId=" + parentId + ", location=" + location + "]";
	}

}
