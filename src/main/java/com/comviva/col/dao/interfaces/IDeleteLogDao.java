package com.comviva.col.dao.interfaces;

import java.util.List;

import com.comviva.col.entity.DeleteLog;

/**
 *
 * @author samarth.sangam
 *
 */
public interface IDeleteLogDao {

	public void addDeleteLog(DeleteLog deleteLog);

	public void addAllDeleteLog(List<DeleteLog> list);

}
