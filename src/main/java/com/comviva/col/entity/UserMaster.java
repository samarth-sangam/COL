package com.comviva.col.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author samarth.sangam
 *
 */
@Entity(name = "COL_USER_MASTER")
public class UserMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	int userId;

	@Column(name = "user_name")
	String username;

	@Column(name = "password")
	String password;

	@Column(name = "e_mail")
	String email;

	// TODO: String or int
	@Column(name = "cell_no", unique = true)
	String mobileNumber;

	// TODO: ENUM {ADMIN, SPOC, USER}
	@Column(name = "type")
	String type;

	@Column(name = "parent_id")
	Integer parentId;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
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
