package com.comviva.col.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.comviva.col.entity.UserMaster;
import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.NotFoundException;
import com.comviva.col.service.interfaces.IUserMasterService;

/**
 * REST apis from UserMaster.
 * 
 * @author samarth.sangam
 *
 */
@RestController
public class UserMasterController {

	@Autowired
	private IUserMasterService userMasterService;

	/**
	 * REST api to add UserMaster.
	 * 
	 * @param userMaster
	 * @return
	 * @throws DuplicateException
	 */
	@PostMapping(value = "/userMaster")
	public String addUserMaster(@Valid @RequestBody UserMaster userMaster) throws DuplicateException {
		return userMasterService.addUserMaster(userMaster);
	}

	/**
	 * REST api to get UserMaster.
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "userMaster/{id}")
	public String getUserMaster(@PathVariable int id, Model model) throws Exception {
		model.addAttribute("userMaster", userMasterService.viewUserMaster(id));
		return "hello";
	}

	/**
	 * REST api to get UserMasters of a particular type.
	 * 
	 * @param type
	 * @return
	 * @throws NotFoundException
	 */
	@GetMapping(value = "userMasterByType/{type}")
	public List<UserMaster> getListUserMasterByType(@PathVariable int type) throws NotFoundException {
		return userMasterService.viewAllByTypeUserMaster(type);
	}

	/**
	 * REST api to update UserMaster.
	 * 
	 * @param userMaster
	 * @return
	 * @throws Exception
	 */
	@PutMapping(value = "/userMaster")
	public UserMaster updateUserMaster(@Valid @RequestBody UserMaster userMaster) throws NotFoundException {
		return userMasterService.updateUserMaster(userMaster);
	}

	@GetMapping(value = "userMasterByParentId/{parentId}")
	public List<UserMaster> getListUserMasterByParentId(@PathVariable int parentId) throws NotFoundException {
		return userMasterService.viewAllByParentId(parentId);
	}
}
