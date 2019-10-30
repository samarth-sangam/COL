package com.comviva.col.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "COL_DELETE_LOG")
public class DeleteLog {

	@Id
	@Column(name = "tr_id")
	int trId;

	@Column(name = "deletion_type")
	String deletionType;

	@Column(name = "date_range")
	String dateRange;

	@Column(name = "user_id")
	int userId;

	public int getTrId() {
		return trId;
	}

	public void setTrId(int trId) {
		this.trId = trId;
	}

	public String getDeletionType() {
		return deletionType;
	}

	public void setDeletionType(String deletionType) {
		this.deletionType = deletionType;
	}

	public String getDateRange() {
		return dateRange;
	}

	public void setDateRange(String dateRange) {
		this.dateRange = dateRange;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
