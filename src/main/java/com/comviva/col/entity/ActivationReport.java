package com.comviva.col.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * 
 * @author samarth.sangam, mahendra.prajapati
 *
 */
@Entity(name = "COL_ACTIVATION_REPORT")
public class ActivationReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tr_id")
	int trId;

	@Column(name = "month")
	String month;

	@Column(name = "activation_date")
	LocalDate activationDate;

	@Column(name = "agent_code")
	String agentCode;

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

	@Column(name = "incentive")
	String incentive;

	@Column(name = "category")
	String category;

	@Column(name = "actiType")
	String actiType;

	@Column(name = "status")
	Character status;

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

	public LocalDate getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(LocalDate activationDate) {
		this.activationDate = activationDate;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
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

	public String getIncentive() {
		return incentive;
	}

	public void setIncentive(String incentive) {
		this.incentive = incentive;
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

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ActivationReport [trId=" + trId + ", month=" + month + ", activationDate=" + activationDate
				+ ", agentCode=" + agentCode + ", externalId=" + externalId + ", mobileNumber=" + mobileNumber
				+ ", name=" + name + ", scheme=" + scheme + ", amount=" + amount + ", incentive=" + incentive
				+ ", category=" + category + ", actiType=" + actiType + ", status=" + status + "]";
	}

}
