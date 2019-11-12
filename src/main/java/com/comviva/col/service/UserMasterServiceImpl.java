package com.comviva.col.service;

import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comviva.col.dao.interfaces.IUserMasterDao;
import com.comviva.col.entity.UserMaster;
import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.InvalidPasswordException;
import com.comviva.col.exceptions.NotFoundException;
import com.comviva.col.service.interfaces.IUserMasterService;
import com.comviva.col.utils.PasswordEncryption;
import com.comviva.col.utils.dto.AuthUserDto;

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

	@Autowired
	private JwtUserDetailsService jwtService;

	private Logger log = Logger.getLogger(UserMasterServiceImpl.class);

	@Override
	public UserMaster addUserMaster(UserMaster userMaster) throws DuplicateException {
		addAuthUserWithMobileNumber(userMaster);
		userMaster.setPassword(PasswordEncryption.encrypt(userMaster.getPassword()));
		try {
			log.info("user found.");
			UserMaster addedUserMaster = userMasterDao.addUserMaster(userMaster);
			addAuthUserWithUserId(addedUserMaster);
			return addedUserMaster;
		} catch (Exception e) {
			log.error("Duplicate record found", e);
			throw new DuplicateException(e);
		}
	}

	private void addAuthUserWithUserId(UserMaster userMaster) {
		AuthUserDto dto = new AuthUserDto();
		dto.setPassword(userMaster.getPassword());
		dto.setUsername(String.valueOf(userMaster.getUserId()));
		dto.setRole(userMaster.getType());
		jwtService.save(dto);

	}

	private void addAuthUserWithMobileNumber(UserMaster userMaster) {
		AuthUserDto dto = new AuthUserDto();
		dto.setPassword(userMaster.getPassword());
		dto.setUsername(userMaster.getMobileNumber());
		dto.setRole(userMaster.getType());
		jwtService.save(dto);

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
			NotFoundException notFoundException = new NotFoundException("User Master with " + id + " not found.");
			log.error("User not found", notFoundException);
			throw notFoundException;
		}
		if (userMaster.getPasswordChangeDate() == null) {
			InvalidPasswordException invalidPasswordException = new InvalidPasswordException("Password Not Set");
			log.error("Wrong password entered.", invalidPasswordException);
			throw invalidPasswordException;
		}
		return userMaster;

	}

	@Override
	public List<UserMaster> viewAllByTypeUserMaster(String type) throws NotFoundException {
		List<UserMaster> list = userMasterDao.viewAllByType(type);
		if (list == null) {
			NotFoundException notFoundException = new NotFoundException("No Entries in the UserMaster table");
			log.error("user not found", notFoundException);
			throw notFoundException;
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
