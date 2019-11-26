package com.comviva.col.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @author samarth.sangam, mahendra.prajapati
 * 
 */
@JsonInclude(Include.NON_NULL)
@Entity(name = "COL_USER_MASTER")
public class UserMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	Integer userId;

	@Column(name = "user_name")
	String username;

	@Column(name = "password")
	String password;

	@Column(name = "e_mail")
	String email;

	@Column(name = "cell_no", unique = true)
	String mobileNumber;

	@Column(name = "type")
	String type;

	@Column(name = "location")
	String location;

	@Column(name = "parent_id")
	Integer parentId;

	@Column(name = "date")
	LocalDateTime passwordChangeDate;

	@Column(name = "on_board_time")
	LocalDateTime onBoardTime = LocalDateTime.now();

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
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

	public LocalDateTime getPasswordChangeDate() {
		return passwordChangeDate;
	}

	public void setPasswordChangeDate(LocalDateTime passwordChangeDate) {
		this.passwordChangeDate = passwordChangeDate;
	}

	public LocalDateTime getOnBoardTime() {
		return onBoardTime;
	}

	public void setOnBoardTime(LocalDateTime onBoardTime) {
		this.onBoardTime = onBoardTime;
	}

	@Override
	public String toString() {
		return "UserMaster [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", type=" + type + ", location=" + location + ", parentId="
				+ parentId + ", passwordChangeDate=" + passwordChangeDate + ", onBoardTime=" + onBoardTime + "]";
	}

}
