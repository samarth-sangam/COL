package com.comviva.col.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author samarth.sangam
 *
 */
@Entity(name = "COL_DEDUCTION_REPORT")
public class DeductionReport {

	@Id
	@Column(name = "tr_id")
	int trId;

	@Column(name = "month")
	String month;

	@Column(name = "agent_code")
	String agentCode;

	@Column(name = "activation_date")
	LocalDate activationDate;

	@Column(name = "external_id")
	String externalId;

	@Column(name = "mobile_number")
	String mobileNumber;

	@Column(name = "name")
	String name;

	@Column(name = "scheme")
	String scheme;

	@Column(name = "amount")
	String amount;

	@Column(name = "category")
	String category;

	@Column(name = "acti_type")
	String actiType;

	@Column(name = "remarks1")
	String Remarks1;

	@Column(name = "remarks2")
	String remarks2;

	@Column(name = "status")
	char status;

	public int getTrId() {
		return trId;
	}

	public void setTrId(int trId) {
		this.trId = trId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public LocalDate getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(LocalDate activationDate) {
		this.activationDate = activationDate;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getActiType() {
		return actiType;
	}

	public void setActiType(String actiType) {
		this.actiType = actiType;
	}

	public String getRemarks1() {
		return Remarks1;
	}

	public void setRemarks1(String remarks1) {
		Remarks1 = remarks1;
	}

	public String getRemarks2() {
		return remarks2;
	}

	public void setRemarks2(String remarks2) {
		this.remarks2 = remarks2;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

}
