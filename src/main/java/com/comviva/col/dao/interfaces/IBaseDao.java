package com.comviva.col.dao.interfaces;

import java.time.LocalDate;
import java.util.List;

/**
 * Base Interface for Dao.
 * 
 * @author samarth.sangam
 *
 * @param <T>
 */
public interface IBaseDao<T> {
	List<T> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String agentCode, String table) throws Exception;
}
