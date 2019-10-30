package com.comviva.col.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comviva.col.dao.interfaces.IUploadLogDao;
import com.comviva.col.entity.UploadLog;
import com.comviva.col.repository.UploadLogRepository;

@Component
public class UploadLogDaoImpl implements IUploadLogDao {

	@Autowired
	private UploadLogRepository uploadLogRepository;

	@Override
	public void addUploadLog(UploadLog uploadLog) {
		uploadLogRepository.save(uploadLog);

	}

	@Override
	public void addAllUploadLog(List<UploadLog> list) {
		uploadLogRepository.saveAll(list);

	}

}
