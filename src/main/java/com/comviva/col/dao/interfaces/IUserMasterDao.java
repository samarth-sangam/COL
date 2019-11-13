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

	/**
	 * Add a list of UserMaster
	 * 
	 * @param list
	 * @return
	 */
	List<UserMaster> addAllUserMaster(List<UserMaster> list);

	/**
	 * Add UserMaster.
	 * 
	 * @param userMaster
	 * @return
	 * @throws Exception
	 */
	UserMaster addUserMaster(UserMaster userMaster) throws Exception;

	/**
	 * View UserMaster by Id
	 * 
	 * @param id
	 * @return
	 */
	UserMaster viewUserMaster(int id);

	/**
	 * View All UserMaster by type.
	 * 
	 * @param type
	 * @return
	 */
	List<UserMaster> viewAllByType(String type);

	/**
	 * Update UserMaster. Check whether userMaster with given id is present or not.
	 * Update is present.
	 * 
	 * @param userMaster
	 * @return
	 * @throws Exception
	 */
	UserMaster updateUserMaster(UserMaster userMaster) throws Exception;

	/**
	 * Delete UserMaster.
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteUserMaster(int id);

	/**
	 * View User Master by Mobile Number.
	 * 
	 * @param mobileNumber
	 * @return
	 */
	UserMaster getByMobileNumber(String mobileNumber);

	/**
	 * Update UserMaster without checking for existences.
	 * 
	 * @param userMaster
	 * @return
	 */
	UserMaster updateWithoutCheckingForUserMaster(UserMaster userMaster);

	/**
	 * View UserMaster by parentId.
	 * 
	 * @param parentId
	 * @return
	 */
	List<UserMaster> viewAllByByParentId(int parentId);
}
