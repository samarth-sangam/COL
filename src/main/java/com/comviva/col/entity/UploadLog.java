package com.comviva.col.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "COL_UPDATE_LOG")
public class UploadLog {

	@Id
	@Column(name = "tr_id")
	int trId;

	@Column(name = "upload_date")
	Date uploadDate;

	@Column(name = "file_path")
	String filePath;

	@Column(name = "user_id")
	int userId;

	public int getTrId() {
		return trId;
	}

	public void setTrId(int trId) {
		this.trId = trId;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
