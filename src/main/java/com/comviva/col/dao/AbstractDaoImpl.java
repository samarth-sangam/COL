package com.comviva.col.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.comviva.col.dao.interfaces.IBaseDao;

/**
 * Abstract dao implementations, provides view By from and to date, and view by
 * month.
 * 
 * @author samarth.sangam
 *
 * @param <T>
 */
public abstract class AbstractDaoImpl<T> implements IBaseDao<T> {

	@PersistenceContext
	private EntityManager entityManager;

	private static final String FROM_TO_DATE_QUERY = "from %s "
			+ "c where agent_code = :agentCode AND activation_date BETWEEN :fromDate AND :toDate";

	private static final String MONTH_QUERY = "from %s where agent_code = :agentCode AND month = :month";

	private static final String DELETE_BY_MONTH = "delete %s where month = :month";

	/**
	 * 
	 */
	@Override
	public List<T> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String agentCode, String tableName) {
		Query query = entityManager.createQuery(String.format(FROM_TO_DATE_QUERY, tableName));
		query.setParameter("agent_code", agentCode);
		query.setParameter("fromDate", Date.valueOf(fromDate));
		query.setParameter("toDate", Date.valueOf(toDate));
		return query.getResultList();
	}

	@Override
	public List<T> viewByMonth(String month, String agentCode, String tableName) {
		Query query = entityManager.createQuery(String.format(MONTH_QUERY, tableName));
		query.setParameter("agentCode", agentCode);
		query.setParameter("month", month);
		return query.getResultList();
	}

	public void deleteByMonth(String month, String id, String tableName) {
		Query query = entityManager.createQuery(String.format(DELETE_BY_MONTH, tableName));
		query.setParameter("month", month);
		query.executeUpdate();
	}
}
