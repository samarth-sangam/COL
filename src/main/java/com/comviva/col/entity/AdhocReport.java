package com.comviva.col.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author samarth.sangam
 *
 */
@Entity(name = "COL_ADHOC_REPORT")
public class AdhocReport {

	@Id
	@Column(name = "trId")
	int trId;

	@Column(name = "adh_date")
	Date adhDate;

	@Column(name = "de_cr_note_no")
	String deCrNoteNo;

	@Column(name = "agent_code")
	String agentCode;

	@Column(name = "activation_date")
	Date activationDate;

	@Column(name = "external_id")
	String externalId;

	@Column(name = "mobile_no")
	String mobileNumber;

	@Column(name = "name")
	String name;

	@Column(name = "old_amount")
	String oldAmount;

	@Column(name = "revised_amount")
	String revisedAmount;

	@Column(name = "net_de_credit")
	String netDeCredit;

	@Column(name = "old_incentive")
	String oldIncentive;

	@Column(name = "revised_incentive")
	String revisedIncentive;

	@Column(name = "net_debit_cr")
	String netDebitCr;

	@Column(name = "remarks1")
	String remarks1;

	@Column(name = "remarks2")
	String remarks2;

	@Column(name = "status")
	char status;

	@Column(name = "month")
	String month;

	public int getTrId() {
		return trId;
	}

	public void setTrId(int trId) {
		this.trId = trId;
	}

	public Date getAdhDate() {
		return adhDate;
	}

	public void setAdhDate(Date adhDate) {
		this.adhDate = adhDate;
	}

	public String getDeCrNoteNo() {
		return deCrNoteNo;
	}

	public void setDeCrNoteNo(String deCrNoteNo) {
		this.deCrNoteNo = deCrNoteNo;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
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

	public String getOldAmount() {
		return oldAmount;
	}

	public void setOldAmount(String oldAmount) {
		this.oldAmount = oldAmount;
	}

	public String getRevisedAmount() {
		return revisedAmount;
	}

	public void setRevisedAmount(String revisedAmount) {
		this.revisedAmount = revisedAmount;
	}

	public String getNetDeCredit() {
		return netDeCredit;
	}

	public void setNetDeCredit(String netDeCredit) {
		this.netDeCredit = netDeCredit;
	}

	public String getOldIncentive() {
		return oldIncentive;
	}

	public void setOldIncentive(String oldIncentive) {
		this.oldIncentive = oldIncentive;
	}

	public String getRevisedIncentive() {
		return revisedIncentive;
	}

	public void setRevisedIncentive(String revisedIncentive) {
		this.revisedIncentive = revisedIncentive;
	}

	public String getNetDebitCr() {
		return netDebitCr;
	}

	public void setNetDebitCr(String netDebitCr) {
		this.netDebitCr = netDebitCr;
	}

	public String getRemarks1() {
		return remarks1;
	}

	public void setRemarks1(String remarks1) {
		this.remarks1 = remarks1;
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

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}
