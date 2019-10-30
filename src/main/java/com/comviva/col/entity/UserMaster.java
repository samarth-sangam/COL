package com.comviva.col.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author samarth.sangam
 *
 */
@Entity(name = "COL_USER_MASTER")
public class UserMaster {

	@NotNull
	@Id
	@Column(name = "user_id")
	int userId;

	@Column(name = "user_name")
	String username;

	@Column(name = "password")
	String password;

	@Column(name = "e_mail")
	String email;

	// TODO: String or int
	@NotNull
	@Column(name = "cell_no")
	String mobileNumber;

	// TODO: ENUM {ADMIN, SPOC, USER}
	@Column(name = "type")
	int type;

	@Column(name = "parent_id")
	int parentId;

	@Column(name = "date")
	LocalDate passwordChangeDate;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public LocalDate getPasswordChangeDate() {
		return passwordChangeDate;
	}

	public void setPasswordChangeDate(LocalDate passwordChangeDate) {
		this.passwordChangeDate = passwordChangeDate;
	}

}
