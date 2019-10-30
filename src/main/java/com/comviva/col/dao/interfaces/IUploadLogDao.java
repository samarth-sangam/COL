package com.comviva.col.dao.interfaces;

import java.util.List;

import com.comviva.col.entity.UploadLog;

public interface IUploadLogDao {

	public void addUploadLog(UploadLog uploadLog);

	public void addAllUploadLog(List<UploadLog> list);
}
