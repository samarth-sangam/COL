package com.comviva.col.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.NoResultException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comviva.col.dao.interfaces.IUserMasterDao;
import com.comviva.col.entity.AuthUser;
import com.comviva.col.entity.UserMaster;
import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.InternalException;
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
		String password = userMaster.getPassword();
		userMaster.setPassword(PasswordEncryption.encrypt(password));
		try {
			UserMaster addedUserMaster = userMasterDao.addUserMaster(userMaster);
			log.debug("User Added with user Id " + addedUserMaster.getUserId());
			addAuthUserWithMobileNumber(userMaster, password);
			addAuthUserWithUserId(addedUserMaster, password);
			return addedUserMaster;
		} catch (Exception e) {
			log.error("Duplicate record found", e);
			throw new DuplicateException(e);
		}
	}

	private void addAuthUserWithUserId(UserMaster userMaster, String password) {
		AuthUserDto dto = new AuthUserDto();
		dto.setPassword(password);
		dto.setUsername(String.valueOf(userMaster.getUserId()));
		dto.setRole(userMaster.getType());
		jwtService.save(dto);

	}

	private void addAuthUserWithMobileNumber(UserMaster userMaster, String password) {
		AuthUserDto dto = new AuthUserDto();
		dto.setPassword(password);
		dto.setUsername(userMaster.getMobileNumber());
		dto.setRole(userMaster.getType());
		jwtService.save(dto);

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
			userMaster.setPassword(PasswordEncryption.encrypt(userMaster.getPassword()));
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
		if (userMaster.getPassword().equals(PasswordEncryption.encrypt(password))) {
			return userMaster;
		}
		throw new InvalidPasswordException("Password doesnot match.");
	}

	@Override
	public UserMaster resetPassword(int id, String password) throws NotFoundException, InvalidPasswordException {
		UserMaster userMaster = userMasterDao.viewUserMaster(id);
		updateAuthUser(userMaster, password);
		userMaster.setPassword(PasswordEncryption.encrypt(password));
		userMaster.setPasswordChangeDate(LocalDateTime.now());
		return userMasterDao.updateWithoutCheckingForUserMaster(userMaster);
	}

	private void updateAuthUser(UserMaster userMaster, String password) {
		AuthUser authUser = jwtService.findAuthUser(userMaster.getMobileNumber());
		if (authUser != null) {
			authUser.setPassword(password);
			jwtService.update(authUser);
		}
		authUser = jwtService.findAuthUser(String.valueOf(userMaster.getUserId()));
		if (authUser != null) {
			authUser.setPassword(password);
			jwtService.update(authUser);
		}
	}

	@Override
	public UserMaster loginUsingMobileNumber(String mobileNumber, String password)
			throws NotFoundException, InvalidPasswordException {
		UserMaster userMaster;
		try {
			userMaster = userMasterDao.getByMobileNumber(mobileNumber);
			if (userMaster.getPassword().equals(PasswordEncryption.encrypt(password))) {
				return userMaster;
			}
			throw new InvalidPasswordException("Password doesnot match.");
		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public List<UserMaster> viewAllByParentId(int parentId) throws NotFoundException {
		List<UserMaster> list = userMasterDao.viewAllByByParentId(parentId);
		if (list == null) {
			throw new NotFoundException("No Entries under User with " + parentId);
		}
		return list;
	}

	@Override
	public UserMaster viewByIdWithoutCheckingPassword(int id) throws NotFoundException {
		UserMaster userMaster = userMasterDao.viewUserMaster(id);

		if (userMaster == null) {
			NotFoundException notFoundException = new NotFoundException("User Master with " + id + " not found.");
			log.error("User not found", notFoundException);
			throw notFoundException;
		}
		return userMaster;
	}

	@Override
	public void addAllUserMaster(List<UserMaster> list) throws DuplicateException {
		System.out.println("dao");
		int count = userMasterDao.saveInBatch(list);
		if (count == 0) {
			return;
		}
		throw new DuplicateException("Number of Duplicates found: " + count);

	}

	@Override
	public List<UserMaster> viewByFromAndToDate(LocalDate fromDate, LocalDate toDate)
			throws NotFoundException, InternalException {
		List<UserMaster> list;
		try {
			list = userMasterDao.viewByFromAndToDate(fromDate, toDate);
		} catch (NoResultException e) {
			NotFoundException notFoundException = new NotFoundException(
					"No Activation Report found from " + fromDate + " to" + toDate);
			log.error("No activation record found between range " + fromDate + " -> " + toDate, notFoundException);
			throw notFoundException;

		}
		return list;
	}

}
