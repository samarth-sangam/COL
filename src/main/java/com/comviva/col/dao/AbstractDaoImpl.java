package com.comviva.col.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.comviva.col.dao.interfaces.IBaseDao;

/**
 * Abstract dao implementations, provides view By from and to date, and view by
 * month.
 * 
 * @author samarth.sangam, mahendra.prajapati
 *
 * @param <T>
 */
public abstract class AbstractDaoImpl<T> implements IBaseDao<T> {

	@PersistenceContext
	private EntityManager entityManager;
	
	private Logger log = Logger.getLogger(AbstractDaoImpl.class);

	private static final String FROM_TO_DATE_QUERY = "from %s "
			+ "c where agent_code = :agentCode AND activation_date BETWEEN :fromDate AND :toDate";

	private static final String MONTH_QUERY = "from %s where agent_code = :agentCode AND month = :month";

	private static final String DELETE_BY_MONTH = "delete %s where month = :month AND agent_code = :agentCode";

	/**
	 * 
	 */
	@Override
	public List<T> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String agentCode, String tableName) {
		log.info("Values={fromDate:"+fromDate+", toDate:"+toDate+", agentCode:"+agentCode+", tableName:"+tableName);
		Query query = entityManager.createQuery(String.format(FROM_TO_DATE_QUERY, tableName));
		if(query == null)
			log.error("Query object is identified as null.");
		query.setParameter("agent_code", agentCode);
		query.setParameter("fromDate", Date.valueOf(fromDate));
		query.setParameter("toDate", Date.valueOf(toDate));
		return query.getResultList();
	}

	@Override
	public List<T> viewByMonth(String month, String agentCode, String tableName) {
		log.info("Values={month:"+month+", agentCode:"+agentCode+", tabelName"+tableName+"}");
		Query query = entityManager.createQuery(String.format(MONTH_QUERY, tableName));
		if(query == null)
			log.error("Query object is identified as null.");
		query.setParameter("agentCode", agentCode);
		query.setParameter("month", month);
		return query.getResultList();
	}

	public void deleteByMonth(String month, String id, String tableName) {
		log.info("Values={month:"+month+", id:"+id+", tableName:"+tableName+"}");
		Query query = entityManager.createQuery(String.format(DELETE_BY_MONTH, tableName));
		if(query == null)
			log.error("Query object is identified as null.");
		query.setParameter("month", month);
		query.setParameter("agentCode", id);
		query.executeUpdate();
	}
}