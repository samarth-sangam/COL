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

	private static final String MONTH = "month";

	private static final String TO_DATE = "toDate";

	private static final String FROM_DATE = "fromDate";

	private static final String AGENT_CODE = "agentCode";

	@PersistenceContext
	private EntityManager entityManager;

	private static final String FROM_TO_DATE_QUERY = "from %s "
			+ "c where agent_code = :agentCode AND activation_date BETWEEN :fromDate AND :toDate";

	private static final String MONTH_QUERY = "from %s where agent_code = :agentCode AND month = :month";

	private static final String DELETE_BY_MONTH = "delete %s where month = :month AND agent_code = :agentCode";

	/**
	 * 
	 */
	@Override
	public List<T> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String agentCode, String tableName) {
		Query query = entityManager.createQuery(String.format(FROM_TO_DATE_QUERY, tableName));
		query.setParameter(AGENT_CODE, agentCode);
		query.setParameter(FROM_DATE, Date.valueOf(fromDate));
		query.setParameter(TO_DATE, Date.valueOf(toDate));

		return query.getResultList();
	}

	@Override
	public List<T> viewByMonth(String month, String agentCode, String tableName) {
		Query query = entityManager.createQuery(String.format(MONTH_QUERY, tableName));
		query.setParameter(AGENT_CODE, agentCode);
		query.setParameter(MONTH, month);
		return query.getResultList();
	}

	public void deleteByMonth(String month, String id, String tableName) {
		Query query = entityManager.createQuery(String.format(DELETE_BY_MONTH, tableName));
		query.setParameter(MONTH, month);
		query.setParameter(AGENT_CODE, id);
		query.executeUpdate();
	}
}
