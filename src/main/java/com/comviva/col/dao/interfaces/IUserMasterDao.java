package com.comviva.col.dao.interfaces;

import java.util.List;

import com.comviva.col.entity.UserMaster;

/**
 * Interface for UserMaster Dao.
 * 
 * @author samarth.sangam
 *
 */
public interface IUserMasterDao {

	void addAllUserMaster(List<UserMaster> list);

	void addUserMaster(UserMaster userMaster) throws Exception;

	UserMaster viewUserMaster(int id);

	List<UserMaster> viewAllByType(int type);

	UserMaster updateUserMaster(UserMaster userMaster) throws Exception;

	boolean deleteUserMaster(int id);

	UserMaster getByMobileNumber(String mobileNumber);

	UserMaster updateWithoutCheckingForUserMaster(UserMaster userMaster);

	List<UserMaster> viewAllByByParentId(int parentId);
}
