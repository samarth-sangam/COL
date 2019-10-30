package com.comviva.col.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comviva.col.dao.interfaces.IDeleteLogDao;
import com.comviva.col.entity.DeleteLog;
import com.comviva.col.repository.DeleteLogRepository;

@Component
public class DeleteLogDaoImpl implements IDeleteLogDao {

	@Autowired
	private DeleteLogRepository deleteLogRepository;

	@Override
	public void addDeleteLog(DeleteLog deleteLog) {
		deleteLogRepository.save(deleteLog);

	}

	@Override
	public void addAllDeleteLog(List<DeleteLog> list) {
		deleteLogRepository.saveAll(list);

	}

}
