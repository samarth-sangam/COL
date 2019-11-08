package com.comviva.col.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comviva.col.dao.interfaces.IUserMasterDao;
import com.comviva.col.entity.UserMaster;
import com.comviva.col.repository.UserMasterRepository;

/**
 * UserMaster Dao implementation.
 * 
 * @author samarth.sangam
 *
 */
@Component
public class UserMasterDaoImpl implements IUserMasterDao {

	@Autowired
	private UserMasterRepository userMasterRepository;

	private static final String VIEW_BY_TYPE = "from %s where type = :type";

	private static final String VIEW_BY_MOBILE_NUMBER = "from %s where cell_no = :cellNo";

	private static final String VIEW_BY_PARENT_ID = "from %s where parent_id = :parentId";

	private static final String TABLE_NAME = "COL_USER_MASTER";

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<UserMaster> addAllUserMaster(List<UserMaster> list) {
		return userMasterRepository.saveAll(list);

	}

	@Override
	public UserMaster addUserMaster(UserMaster userMaster) throws Exception {
		if (exists(userMaster.getUserId())) {
			throw new Exception("User Master with id " + userMaster.getUserId() + " exists.");
		}
		return userMasterRepository.save(userMaster);

	}

	@Override
	public UserMaster viewUserMaster(int id) {
		Optional<UserMaster> userMaster = userMasterRepository.findById(id);
		if (userMaster.isPresent()) {
			return userMaster.get();
		}
		return null;
	}

	@Override
	public UserMaster updateUserMaster(UserMaster userMaster) throws Exception {
		if (exists(userMaster.getUserId())) {
			return userMasterRepository.save(userMaster);
		}
		throw new Exception("UserMaster not Found");
	}

	private boolean exists(int userId) {
		return userMasterRepository.existsById(userId);
	}

	@Override
	public boolean deleteUserMaster(int id) {
		if (exists(id)) {
			userMasterRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<UserMaster> viewAllByType(String type) {
		Query query = entityManager.createQuery(String.format(VIEW_BY_TYPE, TABLE_NAME));
		query.setParameter("type", type);
		return query.getResultList();
	}

	@Override
	public UserMaster getByMobileNumber(String mobileNumber) {
		Query query = entityManager.createQuery(String.format(VIEW_BY_MOBILE_NUMBER, TABLE_NAME));
		query.setParameter("cellNo", mobileNumber);
		return (UserMaster) query.getSingleResult();
	}

	@Override
	public UserMaster updateWithoutCheckingForUserMaster(UserMaster userMaster) {
		return userMasterRepository.save(userMaster);
	}

	@Override
	public List<UserMaster> viewAllByByParentId(int parentId) {
		Query query = entityManager.createQuery(String.format(VIEW_BY_PARENT_ID, TABLE_NAME));
		query.setParameter("parentId", parentId);
		return query.getResultList();
	}

}
