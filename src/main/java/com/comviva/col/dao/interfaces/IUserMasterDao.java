package com.comviva.col.dao.interfaces;

import java.util.List;

import com.comviva.col.entity.UserMaster;

/**
 * Interface for UserMaster Dao.
 * 
 * @author samarth.sangam, mahendra.prajapati
 *
 */
public interface IUserMasterDao {

	List<UserMaster> addAllUserMaster(List<UserMaster> list);

	UserMaster addUserMaster(UserMaster userMaster) throws Exception;

	UserMaster viewUserMaster(int id);

	List<UserMaster> viewAllByType(String type);

	UserMaster updateUserMaster(UserMaster userMaster) throws Exception;

	boolean deleteUserMaster(int id);

	UserMaster getByMobileNumber(String mobileNumber);

	UserMaster updateWithoutCheckingForUserMaster(UserMaster userMaster);

	List<UserMaster> viewAllByByParentId(int parentId);
}
