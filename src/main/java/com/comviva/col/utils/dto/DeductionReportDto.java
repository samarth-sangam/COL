package com.comviva.col.utils.dto;

import java.time.LocalDate;

/**
 * 
 * @author samarth.sangam
 *
 */
public class DeductionReportDto {
	String month;

	String agentCode;

	LocalDate activationDate;

	String externalId;

	String mobileNumber;

	String name;

	String scheme;

	String amount;

	String category;

	String actiType;

	String Remarks1;

	String remarks2;

	private DeductionReportDto(DeductionReportBuilder builder) {
		this.actiType = builder.actiType;
		this.activationDate = builder.activationDate;
		this.agentCode = builder.agentCode;
		this.amount = builder.amount;
		this.category = builder.category;
		this.externalId = builder.externalId;
		this.mobileNumber = builder.mobileNumber;
		this.month = builder.month;
		this.name = builder.name;
		this.Remarks1 = builder.Remarks1;
		this.remarks2 = builder.remarks2;

	}

	public DeductionReportDto() {
		// TODO Auto-generated constructor stub
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

	public static class DeductionReportBuilder {

		String month;

		String agentCode;

		LocalDate activationDate;

		String externalId;

		String mobileNumber;

		String name;

		String scheme;

		String amount;

		String category;

		String actiType;

		String Remarks1;

		String remarks2;

		public DeductionReportBuilder setMonth(String month) {
			this.month = month;
			return this;
		}

		public DeductionReportBuilder setAgentCode(String agentCode) {
			this.agentCode = agentCode;
			return this;
		}

		public DeductionReportBuilder setActivationDate(LocalDate activationDate) {
			this.activationDate = activationDate;
			return this;
		}

		public DeductionReportBuilder setExternalId(String externalId) {
			this.externalId = externalId;
			return this;
		}

		public DeductionReportBuilder setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
			return this;
		}

		public DeductionReportBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public DeductionReportBuilder setScheme(String scheme) {
			this.scheme = scheme;
			return this;
		}

		public DeductionReportBuilder setAmount(String amount) {
			this.amount = amount;
			return this;
		}

		public DeductionReportBuilder setCategory(String category) {
			this.category = category;
			return this;
		}

		public DeductionReportBuilder setActiType(String actiType) {
			this.actiType = actiType;
			return this;
		}

		public DeductionReportBuilder setRemarks1(String remarks1) {
			Remarks1 = remarks1;
			return this;
		}

		public DeductionReportBuilder setRemarks2(String remarks2) {
			this.remarks2 = remarks2;
			return this;
		}

		public DeductionReportDto build() {
			return new DeductionReportDto(this);
		}

	}
}
