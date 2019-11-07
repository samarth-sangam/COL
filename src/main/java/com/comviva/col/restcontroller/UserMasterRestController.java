package com.comviva.col.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/userMaster")
public class UserMasterRestController {

	@Autowired
	private IUserMasterService userMasterService;

	/**
	 * REST api to add UserMaster.
	 * 
	 * @param userMaster
	 * @return
	 * @throws DuplicateException
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@CrossOrigin
	@PostMapping(value = "/userMaster", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addUserMaster(@RequestBody UserMaster userMaster) throws DuplicateException {
		return ResponseEntity.ok(userMasterService.addUserMaster(userMaster));
	}

	/**
	 * REST api to get UserMaster.
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@CrossOrigin
	@GetMapping(value = "/userMaster/{id}")
	public ResponseEntity<?> getUserMaster(@PathVariable int id) {
		return ResponseEntity.ok(userMasterService.viewUserMaster(id));
	}

	/**
	 * REST api to get UserMasters of a particular type.
	 * 
	 * @param type
	 * @return
	 * @throws NotFoundException
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@CrossOrigin
	@GetMapping(value = "userMaster/type/{type}")
	public ResponseEntity<?> getListUserMasterByType(@PathVariable int type) throws NotFoundException {
		return ResponseEntity.ok(userMasterService.viewAllByTypeUserMaster(type));
	}

	/**
	 * REST api to update UserMaster.
	 * 
	 * @param userMaster
	 * @return
	 * @throws Exception
	 */
	@PreAuthorize("hasAnyRole('USER', 'CIRCLE', 'ADMIN')")
	@PutMapping(value = "/userMaster")
	public ResponseEntity<?> updateUserMaster(@RequestBody UserMaster userMaster) throws NotFoundException {
		return ResponseEntity.ok(userMasterService.updateUserMaster(userMaster));
	}

	/**
	 * REST api to get UserMasters by parentId
	 * 
	 * @param parentId
	 * @return
	 * @throws NotFoundException
	 */
	@PreAuthorize("hasAnyRole('ADMIN', 'CIRCLE')")
	@GetMapping(value = "userMaster/parentId/{parentId}")
	public ResponseEntity<?> getListUserMasterByParentId(@PathVariable int parentId) throws NotFoundException {
		return ResponseEntity.ok(userMasterService.viewAllByParentId(parentId));
	}
}
