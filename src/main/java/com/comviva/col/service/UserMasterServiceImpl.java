package com.comviva.col.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comviva.col.dao.interfaces.IUserMasterDao;
import com.comviva.col.entity.UserMaster;
import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.InvalidPasswordException;
import com.comviva.col.exceptions.NotFoundException;
import com.comviva.col.service.interfaces.IUserMasterService;
import com.comviva.col.utils.PasswordEncryption;

/**
 * UserMaster Service Implementations.
 * 
 * @author samarth.sangam
 *
 */
@Service
public class UserMasterServiceImpl implements IUserMasterService {

	@Autowired
	private IUserMasterDao userMasterDao;

	@Override
	public UserMaster addUserMaster(UserMaster userMaster) throws DuplicateException {
		userMaster.setPassword(PasswordEncryption.encrypt(userMaster.getPassword()));
		try {
			return userMasterDao.addUserMaster(userMaster);
		} catch (Exception e) {
			throw new DuplicateException(e);
		}
	}

	@Override
	public String addAllUserMaster(List<UserMaster> list) {
		userMasterDao.addAllUserMaster(list);
		return "All Added";
	}

	@Override
	public UserMaster viewUserMaster(int id) throws NotFoundException, InvalidPasswordException {
		UserMaster userMaster = userMasterDao.viewUserMaster(id);

		if (userMaster == null) {
			throw new NotFoundException("User Master with " + id + " not found.");
		}
		if (userMaster.getPasswordChangeDate() == null) {
			throw new InvalidPasswordException("Password Not Set");
		}
		return userMaster;

	}

	@Override
	public List<UserMaster> viewAllByTypeUserMaster(String type) throws NotFoundException {
		List<UserMaster> list = userMasterDao.viewAllByType(type);
		if (list == null) {
			throw new NotFoundException("No Entries in the UserMaster table");
		}
		return list;
	}

	@Override
	public UserMaster updateUserMaster(UserMaster userMaster) throws NotFoundException {
		try {
			return userMasterDao.updateUserMaster(userMaster);
		} catch (Exception e) {
			throw new NotFoundException("UserMaster with id " + userMaster.getUserId() + ".");
		}
	}

	@Override
	public UserMaster loginUsingUserId(int id, String password) throws NotFoundException, InvalidPasswordException {
		UserMaster userMaster = userMasterDao.viewUserMaster(id);
		if (userMaster == null) {
			throw new NotFoundException("Check the UserId.");
		}
		if (userMaster.getPassword().equalsIgnoreCase(password)) {
			return userMaster;
		}
		throw new InvalidPasswordException("Password doesnot match.");
	}

	@Override
	public UserMaster resetPassword(int id, String password) throws NotFoundException, InvalidPasswordException {
		UserMaster userMaster = this.viewUserMaster(id);
		userMaster.setPasswordChangeDate(LocalDate.now());
		return userMasterDao.updateWithoutCheckingForUserMaster(userMaster);
	}

	@Override
	public UserMaster loginUsingMobileNumber(String mobileNumber, String password)
			throws NotFoundException, InvalidPasswordException {
		UserMaster userMaster = userMasterDao.getByMobileNumber(mobileNumber);
		if (userMaster == null) {
			throw new NotFoundException("Check Mobile Number");
		}
		if (userMaster.getPassword().equalsIgnoreCase(password)) {
			return userMaster;
		}
		throw new InvalidPasswordException("Password doesnot match.");
	}

	@Override
	public List<UserMaster> viewAllByParentId(int parentId) throws NotFoundException {
		List<UserMaster> list = userMasterDao.viewAllByByParentId(parentId);
		if (list == null) {
			throw new NotFoundException("No Entries under User with " + parentId);
		}
		return list;
	}

}
