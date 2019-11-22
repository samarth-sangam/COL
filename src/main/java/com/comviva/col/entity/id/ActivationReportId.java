/**
 * 
 */
package com.comviva.col.entity.id;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author samarth.sangam
 *
 */
public class ActivationReportId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	LocalDateTime activationDate;

	String agentCode;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activationDate == null) ? 0 : activationDate.hashCode());
		result = prime * result + ((agentCode == null) ? 0 : agentCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActivationReportId other = (ActivationReportId) obj;
		if (activationDate == null) {
			if (other.activationDate != null)
				return false;
		} else if (!activationDate.equals(other.activationDate))
			return false;
		if (agentCode == null) {
			if (other.agentCode != null)
				return false;
		} else if (!agentCode.equals(other.agentCode))
			return false;
		return true;
	}

}
