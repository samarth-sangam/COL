package com.comviva.col.dao.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.comviva.col.entity.UserMaster;
import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.InternalException;

/**
 * Interface for UserMaster Dao.
 * 
 * @author samarth.sangam, mahendra.prajapati
 *
 */
public interface IUserMasterDao {

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

	/**
	 * Save In Batch. Creates Auth Table entry aswell.
	 * 
	 * @param entities
	 * @return
	 */
	int saveInBatch(Iterable<UserMaster> entities);

	/**
	 * 
	 * @param fromDate
	 * @param toDate
	 * @return
	 * @throws InternalException
	 */
	List<UserMaster> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate) throws InternalException;

	/**
	 * Update UserMaster. Check whether userMaster with given id is present or not.
	 * Update is present.
	 * 
	 * @param userMaster
	 * @return
	 * @throws Exception
	 */
	UserMaster updateUserMaster(UserMaster userMaster, int id) throws DuplicateException;
}
