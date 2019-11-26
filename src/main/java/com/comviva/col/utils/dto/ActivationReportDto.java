package com.comviva.col.utils.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * ActivationReport Data transfer Object.
 * 
 * @author samarth.sangam
 * @deprecated
 *
 */
@Deprecated
@JsonInclude(Include.NON_NULL)
public class ActivationReportDto {

	String trId;

	private String month;

	private LocalDateTime activationDate;

	private String agentCode;

	private String externalId;

	private String mobileNumber;

	private String name;

	private String scheme;

	private String amount;

	private String incentive;

	private String category;

	private String actiType;

	private Character status;

	private ActivationReportDto(ActivationReportBuilder builder) {
		this.trId = builder.trId;
		this.month = builder.month;
		this.actiType = builder.actiType;
		this.activationDate = builder.activationDate;
		this.agentCode = builder.agentCode;
		this.category = builder.category;
		this.externalId = builder.externalId;
		this.incentive = builder.incentive;
		this.mobileNumber = builder.mobileNumber;
		this.name = builder.name;
		this.amount = builder.amount;
		this.status = builder.status;
	}

	public ActivationReportDto() {
	}

	public String getTrId() {
		return trId;
	}

	public void setTrId(String trId) {
		this.trId = trId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public LocalDateTime getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(LocalDateTime activationDate) {
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

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public static class ActivationReportBuilder {

		String trId;

		String month;

		LocalDateTime activationDate;

		String agentCode;

		String externalId;

		String mobileNumber;

		String name;

		String scheme;

		String incentive;

		String category;

		String actiType;

		String amount;

		Character status;

		public ActivationReportBuilder setTrId(String trId) {
			this.trId = trId;
			return this;
		}

		public ActivationReportBuilder setMonth(String month) {
			this.month = month;
			return this;
		}

		public ActivationReportBuilder setActivationDate(LocalDateTime activationDate) {
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

		public ActivationReportBuilder setAmount(String amount) {
			this.amount = amount;
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

		public ActivationReportBuilder setStatus(Character status) {
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
