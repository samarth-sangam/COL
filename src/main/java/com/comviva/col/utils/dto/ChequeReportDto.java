package com.comviva.col.utils.dto;

/**
 * 
 * @author samarth.sangam
 *
 */
public class ChequeReportDto {

	String agentCode;

	String noOfCheques;

	public ChequeReportDto(String agentCode, String noOfCheques) {
		this.agentCode = agentCode;
		this.noOfCheques = noOfCheques;
	}

	public ChequeReportDto() {
		// TODO Auto-generated constructor stub
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

}
