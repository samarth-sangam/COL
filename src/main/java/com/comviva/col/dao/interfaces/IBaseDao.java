package com.comviva.col.dao.interfaces;

import java.time.LocalDate;
import java.util.List;

/**
 * Base Interface for Dao.
 * 
 * @author samarth.sangam, mahendra.prajapati
 *
 * @param <T>
 */
public interface IBaseDao<T> {
	List<T> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String agentCode, String table);

	List<T> viewByMonth(String month, String id, String table);
}
