package com.comviva.col.dao;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.comviva.col.dao.interfaces.IUserMasterDao;
import com.comviva.col.entity.AuthUser;
import com.comviva.col.entity.UserMaster;
import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.InternalException;
import com.comviva.col.repository.UserMasterRepository;
import com.comviva.col.utils.PasswordEncryption;

/**
 * UserMaster Dao implementation.
 * 
 * @author samarth.sangam, mahendra.prajapati
 *
 */
@Component
public class UserMasterDaoImpl implements IUserMasterDao {

	private static final String QUERY_FIRED_FOR_VIEW_ALL_BY_TYPE_S_ON_TABLE = "Query fired for view all by type{ %s } on table = ";

	private static final String QUERY_OBJECT_IS_IDENTIFIED_AS_NULL = "Query object is identified as null.";

	private static final String USER_FOUND_WITH_ID = "User found with id = ";

	private static final String USER_NOT_FOUND_WITH_ID = "User not found with id = ";

	private static final String VIEW_BY_TYPE = "from %s where type = :type";

	private static final String VIEW_BY_MOBILE_NUMBER = "from %s where cell_no = :cellNo";

	private static final String VIEW_BY_PARENT_ID = "from %s where parent_id = :parentId";

	private static final String VIEW_BY_ON_BOARDING_TIME = "from %s where on_board_time BETWEEN :fromDate AND :toDate";

	private static final String TABLE_NAME = "COL_USER_MASTER";

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
	private int batchSize;

	@Autowired
	private UserMasterRepository userMasterRepository;

	@PersistenceContext
	private EntityManager entityManager;

	private Logger log = Logger.getLogger(UserMasterDaoImpl.class);

	@Override
	public UserMaster addUserMaster(UserMaster userMaster) throws DuplicateException {
		if (existsByMobileNumber(userMaster.getMobileNumber())) {
			log.error(userMaster + "already exists.");
			throw new DuplicateException("User Master with mobile number " + userMaster.getMobileNumber() + " exists.");
		}
		log.info("User found with id " + userMaster.getUserId());
		return userMasterRepository.save(userMaster);

	}

	@Override
	public UserMaster viewUserMaster(int id) {
		Optional<UserMaster> userMaster = userMasterRepository.findById(id);
		if (userMaster.isPresent()) {
			log.info(UserMasterDaoImpl.USER_FOUND_WITH_ID + id);
			return userMaster.get();
		}
		log.error(UserMasterDaoImpl.USER_NOT_FOUND_WITH_ID + id);
		return null;
	}

	@Override
	public UserMaster updateUserMaster(UserMaster userMaster, int id) throws DuplicateException {
		UserMaster u = this.viewUserMaster(id);
		System.out.println(u);
		if (u == null) {
			log.error(UserMasterDaoImpl.USER_NOT_FOUND_WITH_ID + userMaster.getUserId());
			throw new DuplicateException("UserMaster not Found");
		}
		u.setEmail(userMaster.getEmail());
		u.setUsername(userMaster.getUsername());
		log.info("Updating the user record for id = " + userMaster.getUserId());
		return userMasterRepository.save(u);
	}

	private boolean exists(int userId) {
		return userMasterRepository.existsById(userId);
	}

	@Override
	public boolean deleteUserMaster(int id) {
		if (exists(id)) {
			userMasterRepository.deleteById(id);
			log.info("User deleted with id = " + id);
			return true;
		}
		log.error(UserMasterDaoImpl.USER_NOT_FOUND_WITH_ID + id);
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserMaster> viewAllByType(String type) {
		log.info(String.format(QUERY_FIRED_FOR_VIEW_ALL_BY_TYPE_S_ON_TABLE, type) + TABLE_NAME);
		Query query = entityManager.createQuery(String.format(VIEW_BY_TYPE, TABLE_NAME));
		if (query == null) {
			log.error(QUERY_OBJECT_IS_IDENTIFIED_AS_NULL);
			return new ArrayList<>();
		}
		query.setParameter("type", type);
		return query.getResultList();
	}

	@Override
	public UserMaster getByMobileNumber(String mobileNumber) {
		log.info(String.format(QUERY_FIRED_FOR_VIEW_ALL_BY_TYPE_S_ON_TABLE, mobileNumber) + TABLE_NAME);
		Query query = entityManager.createQuery(String.format(VIEW_BY_MOBILE_NUMBER, TABLE_NAME));
		if (query == null) {
			log.error(QUERY_OBJECT_IS_IDENTIFIED_AS_NULL);
			return null;
		}
		if (mobileNumber != null)
			query.setParameter("cellNo", mobileNumber);
		return (UserMaster) query.getSingleResult();
	}

	private boolean existsByMobileNumber(String mobileNumber) {
		try {
			this.getByMobileNumber(mobileNumber);
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}

	@Override
	public UserMaster updateWithoutCheckingForUserMaster(UserMaster userMaster) {
		return userMasterRepository.save(userMaster);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserMaster> viewAllByByParentId(int parentId) {
		log.info(String.format(QUERY_FIRED_FOR_VIEW_ALL_BY_TYPE_S_ON_TABLE, parentId) + TABLE_NAME);
		Query query = entityManager.createQuery(String.format(VIEW_BY_PARENT_ID, TABLE_NAME));
		if (query == null) {
			log.error("Query object is identified as null");
			return null;
		}
		query.setParameter("parentId", parentId);
		return query.getResultList();
	}

	@Override
	@Transactional
	public int saveInBatch(Iterable<UserMaster> entities) {
		int notAddedCount = 0;
		if (entities == null) {
			throw new IllegalArgumentException("The given Iterable of entities cannot be null!");
		}

		int i = 0;

		for (UserMaster entity : entities) {
			String password = entity.getPassword();
			entity.setPassword(PasswordEncryption.encrypt(password));
			Integer id = new Integer(entity.getUserId());

			try {
				this.getByMobileNumber(entity.getMobileNumber());

			} catch (NoResultException e) {
				if (entityManager.find(UserMaster.class, id) == null) {
					entityManager.persist(entity);
					System.out.println(entity);
					AuthUser authUser = new AuthUser();
					authUser.setPassword(bcryptEncoder.encode(password));
					authUser.setRole(entity.getType());
					authUser.setUsername(entity.getMobileNumber());
					entityManager.persist(authUser);
				} else {
					entityManager.detach(entity);
					notAddedCount++;
				}
			}

			i++;

			// Flush a batch of inserts and release memory
			if (i % batchSize == 0 && i > 0) {
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

	@SuppressWarnings("unchecked")
	@Override
	public List<UserMaster> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate) throws InternalException {
		log.info("Values={fromDate:" + fromDate + ", toDate:" + toDate);
		Query query = entityManager.createQuery(String.format(VIEW_BY_ON_BOARDING_TIME, TABLE_NAME));

		if (query == null) {
			log.error(QUERY_OBJECT_IS_IDENTIFIED_AS_NULL);
			throw new InternalException("Internal Error");
		}

		LocalDateTime from = LocalDateTime.of(fromDate, LocalTime.now());
		LocalDateTime to = LocalDateTime.of(toDate, LocalTime.now());
		query.setParameter("fromDate", Timestamp.valueOf(from));
		query.setParameter("toDate", Timestamp.valueOf(to));

		return query.getResultList();
	}

}
