package com.comviva.col.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author samarth.sangam
 *
 */
@Entity(name = "COL_CHEQUE_REPORT")
public class ChequeReport {

	@Id
	@Column(name = "tr_id")
	int trId;

	@Column(name = "agent_code")
	String agentCode;

	@Column(name = "no_of_cheques")
	String noOfCheques;

	@Column(name = "status")
	char status;

	public int getTrId() {
		return trId;
	}

	public void setTrId(int trId) {
		this.trId = trId;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public String getNoOfCheques() {
		return noOfCheques;
	}

	public void setNoOfCheques(String noOfCheques) {
		this.noOfCheques = noOfCheques;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

}
