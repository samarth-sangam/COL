package com.comviva.col.service.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.comviva.col.entity.UserMaster;
import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.InternalException;
import com.comviva.col.exceptions.InvalidPasswordException;
import com.comviva.col.exceptions.NotFoundException;

/**
 * Interface for UserMaster Service.
 * 
 * @author samarth.sangam, mahendra.prajapati
 *
 */
public interface IUserMasterService {

	/**
	 * Add UserMaster if userMaster userId is unique else throws DuplicateException.
	 * 
	 * @param userMaster
	 * @return
	 * @throws DuplicateException
	 */
	UserMaster addUserMaster(UserMaster userMaster) throws DuplicateException;

	/**
	 * View UserMaster by id.
	 * 
	 * @param id
	 * @return
	 * @throws NotFoundException
	 */
	UserMaster viewUserMaster(int id) throws NotFoundException, InvalidPasswordException;

	/**
	 * View All UserMaster by Type.
	 * 
	 * @param type
	 * @return
	 * @throws NotFoundException
	 */
	List<UserMaster> viewAllByTypeUserMaster(String type) throws NotFoundException;

	/**
	 * Login by userId and password.
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	UserMaster loginUsingUserId(int userId, String password) throws NotFoundException, InvalidPasswordException;

	/**
	 * Login by mobile number and password.
	 * 
	 * @param mobileNumber
	 * @param password
	 * @return
	 * @throws Exception
	 */
	UserMaster loginUsingMobileNumber(String mobileNumber, String password)
			throws NotFoundException, InvalidPasswordException;

	/**
	 * Reset Password.
	 * 
	 * @param id
	 * @param password
	 * @return
	 * @throws Exception
	 */
	UserMaster resetPassword(int id, String password) throws NotFoundException, InvalidPasswordException;

	/**
	 * View List of UserMaster by parentId.
	 * 
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	List<UserMaster> viewAllByParentId(int parentId) throws NotFoundException;

	/**
	 * Return User without checking userMaster.
	 * 
	 * @param id
	 * @return
	 * @throws NotFoundException
	 */
	UserMaster viewByIdWithoutCheckingPassword(int id) throws NotFoundException;

	/**
	 * 
	 * @param list
	 * @throws DuplicateException
	 */
	void addAllUserMaster(List<UserMaster> list) throws DuplicateException;

	/**
	 * 
	 * @param localDate
	 * @param localDate2
	 * @return
	 * @throws InternalException
	 * @throws NotFoundException
	 * @throws Exception
	 */
	List<UserMaster> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate)
			throws NotFoundException, InternalException;

	/**
	 * Updates UserMaster if userMaster with userId exists else throws exceptions.
	 * 
	 * @param userMaster
	 * @return
	 * @throws NotFoundException
	 */

	UserMaster updateUserMaster(UserMaster userMaster, int id) throws NotFoundException;

}
