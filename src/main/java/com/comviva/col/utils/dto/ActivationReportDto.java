package com.comviva.col.utils.dto;

import java.time.LocalDate;

/**
 * ActivationReport Data transfer Object.
 * 
 * @author samarth.sangam
 *
 */
public class ActivationReportDto {

	private String month;

	private LocalDate activationDate;

	private String agentCode;

	private String externalId;

	private String mobileNumber;

	private String name;

	private String scheme;

	private String incentive;

	private String category;

	private String actiType;

	private char status;

	private ActivationReportDto(ActivationReportBuilder builder) {
		this.month = builder.month;
		this.actiType = builder.actiType;
		this.activationDate = builder.activationDate;
		this.agentCode = builder.agentCode;
		this.category = builder.category;
		this.externalId = builder.externalId;
		this.incentive = builder.incentive;
		this.mobileNumber = builder.mobileNumber;
		this.name = builder.name;
		this.status = builder.status;
	}

	public ActivationReportDto() {
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

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public static class ActivationReportBuilder {

		String month;

		LocalDate activationDate;

		String agentCode;

		String externalId;

		String mobileNumber;

		String name;

		String scheme;

		String incentive;

		String category;

		String actiType;

		char status;

		public ActivationReportBuilder setMonth(String month) {
			this.month = month;
			return this;
		}

		public ActivationReportBuilder setActivationDate(LocalDate activationDate) {
			this.activationDate = activationDate;
			return this;
		}

		public ActivationReportBuilder setAgentCode(String agentCode) {
			this.agentCode = agentCode;
			return this;
		}

		public ActivationReportBuilder setExternalId(String externalId) {
			this.externalId = externalId;
			return this;
		}

		public ActivationReportBuilder setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
			return this;
		}

		public ActivationReportBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public ActivationReportBuilder setScheme(String scheme) {
			this.scheme = scheme;
			return this;
		}

		public ActivationReportBuilder setIncentive(String incentive) {
			this.incentive = incentive;
			return this;
		}

		public ActivationReportBuilder setCategory(String category) {
			this.category = category;
			return this;
		}

		public ActivationReportBuilder setActiType(String actiType) {
			this.actiType = actiType;
			return this;
		}

		public ActivationReportBuilder setStatus(char status) {
			this.status = status;
			return this;
		}

		public ActivationReportDto build() {
			return new ActivationReportDto(this);
		}

	}

	@Override
	public String toString() {
		return "ActivationReportDto [month=" + month + ", activationDate=" + activationDate + ", agentCode=" + agentCode
				+ ", externalId=" + externalId + ", mobileNumber=" + mobileNumber + ", name=" + name + ", scheme="
				+ scheme + ", incentive=" + incentive + ", category=" + category + ", actiType=" + actiType
				+ ", status=" + status + "]";
	}

}
