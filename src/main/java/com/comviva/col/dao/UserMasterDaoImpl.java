package com.comviva.col.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comviva.col.dao.interfaces.IUserMasterDao;
import com.comviva.col.entity.UserMaster;
import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.repository.UserMasterRepository;

/**
 * UserMaster Dao implementation.
 * 
 * @author samarth.sangam, mahendra.prajapati
 *
 */
@Component
public class UserMasterDaoImpl implements IUserMasterDao {

	private static final String USER_FOUND_WITH_ID = "User found with id = ";

	private static final String USER_NOT_FOUND_WITH_ID = "User not found with id = ";

	private static final String VIEW_BY_TYPE = "from %s where type = :type";

	private static final String VIEW_BY_MOBILE_NUMBER = "from %s where cell_no = :cellNo";

	private static final String VIEW_BY_PARENT_ID = "from %s where parent_id = :parentId";

	private static final String TABLE_NAME = "COL_USER_MASTER";

	@Autowired
	private UserMasterRepository userMasterRepository;

	@PersistenceContext
	private EntityManager entityManager;

	private Logger log = Logger.getLogger(UserMasterDaoImpl.class);

	@Override
	public UserMaster addUserMaster(UserMaster userMaster) throws Exception {
		if (existsByMobileNumber(userMaster.getMobileNumber())) {
			log.error(userMaster + "already exists.");
			throw new Exception("User Master with mobile number " + userMaster.getMobileNumber() + " exists.");
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
	public UserMaster updateUserMaster(UserMaster userMaster) throws DuplicateException {
		if (exists(userMaster.getUserId())) {
			log.info("Updating the user record for id = " + userMaster.getUserId());
			return userMasterRepository.save(userMaster);
		}
		log.error(UserMasterDaoImpl.USER_NOT_FOUND_WITH_ID + userMaster.getUserId());
		throw new DuplicateException("UserMaster not Found");
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
		log.info("Query fired for view all by type{" + type + "} on table = " + TABLE_NAME);
		Query query = entityManager.createQuery(String.format(VIEW_BY_TYPE, TABLE_NAME));
		if (query == null) {
			log.error("Query object is identified as null.");
			return new ArrayList<>();
		}
		query.setParameter("type", type);
		return query.getResultList();
	}

	@Override
	public UserMaster getByMobileNumber(String mobileNumber) {
		log.info("Query fired for get by mobile number{" + mobileNumber + "} on table = " + TABLE_NAME);
		Query query = entityManager.createQuery(String.format(VIEW_BY_MOBILE_NUMBER, TABLE_NAME));
		if (query == null) {
			log.error("Query object is identified as null.");
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
		log.info("Query fired for view by parentId{" + parentId + "} on table = " + TABLE_NAME);
		Query query = entityManager.createQuery(String.format(VIEW_BY_PARENT_ID, TABLE_NAME));
		if (query == null) {
			log.error("Query object is identified as null");
			return null;
		}
		query.setParameter("parentId", parentId);
		return query.getResultList();
	}

}
