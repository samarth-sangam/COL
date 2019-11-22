package com.comviva.col.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Value;

import com.comviva.col.dao.interfaces.IBaseDao;
import com.comviva.col.entity.ActivationReport;
import com.comviva.col.entity.id.ActivationReportId;

/**
 * Abstract dao implementations, provides view By from and to date, and view by
 * month.
 * 
 * @author samarth.sangam
 *
 * @param <T>
 */
public abstract class AbstractDaoImpl<T extends ActivationReport, I extends ActivationReportId> implements IBaseDao<T> {

	private static final String TO_DATE = "toDate";

	private static final String FROM_DATE = "fromDate";

	private static final String AGENT_CODE = "agentCode";

	@Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
	private int batchSize;
	@PersistenceContext
	private EntityManager entityManager;

	private Logger log = Logger.getLogger(AbstractDaoImpl.class);

	private static final String FROM_TO_DATE_QUERY = "from %s "
			+ "c where agent_code = :agentCode AND activation_date BETWEEN :fromDate AND :toDate";

	/**
	 * Generic method to find row by between fromDate to toDate by agentCode.
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate, String agentCode, String tableName)
			throws Exception {
		log.info("Values={fromDate:" + fromDate + ", toDate:" + toDate + ", agentCode:" + agentCode + ", tableName:"
				+ tableName);
		Query query = entityManager.createQuery(String.format(FROM_TO_DATE_QUERY, tableName));

		if (query == null) {
			log.error("Query object is identified as null.");
			throw new Exception("Internal Error");
		}

		query.setParameter(AGENT_CODE, agentCode);
		query.setParameter(FROM_DATE, Date.valueOf(fromDate));
		query.setParameter(TO_DATE, Date.valueOf(toDate));

		return query.getResultList();
	}

	@Transactional
	public <S extends ActivationReport, I extends ActivationReportId> int saveInBatch(Iterable<S> entities) {

		int notAddedCount = 0;
		if (entities == null) {
			throw new IllegalArgumentException("The given Iterable of entities cannot be null!");
		}

		int i = 0;

		Session session = entityManager.unwrap(Session.class);
		session.setJdbcBatchSize(batchSize);

		for (S entity : entities) {
			ActivationReportId id = new ActivationReportId();
			id.setActivationDate(entity.getActivationDate());
			id.setAgentCode(entity.getAgentCode());

			if (entityManager.find(ActivationReport.class, id) != null) {
				entityManager.detach(entity);
				notAddedCount++;
			} else {
				entityManager.persist(entity);
			}

			i++;

			// Flush a batch of inserts and release memory
			if (i % session.getJdbcBatchSize() == 0 && i > 0) {
				log.info("Flushing the EntityManager containing {0} entities ..." + i);

				entityManager.flush();
				entityManager.clear();
				i = 0;
			}
		}

		if (i > 0)

		{
			log.info("Flushing the remaining {0} entities ..." + i);

			entityManager.flush();
			entityManager.clear();
		}
		return notAddedCount;
	}

}