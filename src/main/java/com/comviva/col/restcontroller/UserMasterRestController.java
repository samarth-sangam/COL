package com.comviva.col.restcontroller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.comviva.col.entity.UserMaster;
import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.InternalException;
import com.comviva.col.exceptions.InvalidPasswordException;
import com.comviva.col.exceptions.NotFoundException;
import com.comviva.col.service.FileStorageService;
import com.comviva.col.service.interfaces.IUserMasterService;
import com.comviva.col.utils.dto.UserMasterDto;
import com.comviva.col.utils.mapper.CSVToEntity;
import com.comviva.col.utils.mapper.UserMasterMapper;

/**
 * REST apis from UserMaster.
 * 
 * @author samarth.sangam, mahendra.prajapati
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/userMaster")
public class UserMasterRestController {

	@Autowired
	private IUserMasterService userMasterService;

	private UserMasterMapper mapper = new UserMasterMapper();

	@Autowired
	private FileStorageService fileStorageService;

	@Autowired
	private CSVToEntity csvMapper;

	private Logger log = Logger.getLogger(UserMasterRestController.class);

	/**
	 * REST api to add UserMaster.
	 * 
	 * @param userMaster
	 * @return
	 * @throws DuplicateException
	 */
	@PreAuthorize("hasAnyRole('CIRCLE', 'ADMIN')")
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/userMaster", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addUserMaster(@RequestBody @Valid UserMasterDto userMaster) throws DuplicateException {
		log.info("Url pattern /api/v1/userMaster/userMaster invoked for adding new user.");
		return ResponseEntity.ok(mapper.toResponse(userMasterService.addUserMaster(mapper.toEntity(userMaster))));
	}

	/**
	 * REST api to get UserMaster.
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @throws InvalidPasswordException
	 * @throws NotFoundException
	 * @throws Exception
	 */
	@PreAuthorize("hasAnyRole('USER', 'CIRCLE', 'ADMIN')")
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/userMaster/{id}")
	public ResponseEntity<?> getUserMaster(@PathVariable int id) throws NotFoundException {
		log.info("Url pattern /api/v1/userMaster/" + id + " invoked quering for user with id(" + id + ")");
		return ResponseEntity.ok(mapper.toResponse(userMasterService.viewByIdWithoutCheckingPassword(id)));
	}

	/**
	 * REST api to get UserMasters of a particular type.
	 * 
	 * @param type
	 * @return
	 * @throws NotFoundException
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@CrossOrigin(origins = "*")
	@GetMapping(value = "userMaster/type/{type}")
	public ResponseEntity<?> getListUserMasterByType(@PathVariable String type) throws NotFoundException {
		log.info("Url pattern /api/v1/userMaster/type/" + type + " invoked for type(" + type + ")");
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
	@PutMapping(value = "/userMaster/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> updateUserMaster(@RequestBody @Valid UserMasterDto userMasterDto, @PathVariable int id)
			throws NotFoundException {
		log.info("Url pattern /api/v1/userMaster/" + id + " invoked for updating.");
		return ResponseEntity
				.ok(mapper.toResponse(userMasterService.updateUserMaster(mapper.toEntity(userMasterDto, id))));
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
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> getListUserMasterByParentId(@PathVariable int parentId) throws NotFoundException {
		log.info("url pattern /api/v1/userMaster/parentid/" + parentId + " invoked");
		return ResponseEntity.ok(userMasterService.viewAllByParentId(parentId));
	}

	/**
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws DuplicateException
	 */
	@PreAuthorize("hasAnyRole('ADMIN', 'CIRCLE')")
	@PostMapping(value = "userMaster/all")
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> addAllUserMaster(@RequestParam("file") MultipartFile file)
			throws IOException, DuplicateException {
		String fileName = fileStorageService.storeFile(file);
		List<UserMaster> list = csvMapper.readCSVintoUserMaster(fileName);
		try {
			userMasterService.addAllUserMaster(list);
			log.info("Reports Added");
		} catch (DuplicateException e) {
			log.info("Duplicates: ", e);
			throw e;
		}
		return ResponseEntity.ok("All UserMaster Added");
	}

	/**
	 * REST api to view ActivationReports from particular data to a particular date.
	 * 
	 * @param fromDate
	 * @param toDate
	 * @param agentCode
	 * @return
	 * @throws InternalException
	 * @throws NotFoundException
	 * @throws Exception
	 */
	@PreAuthorize("hasAnyRole('USER', 'CIRCLE', 'ADMIN')")
	@GetMapping(value = "/activationReports")
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> viewActivationReportFromAndToDate(@RequestParam(required = true) String fromDate,
			@RequestParam(required = true) String toDate) throws NotFoundException, InternalException {
		log.info(
				"Url pattern /api/v1/activationReport/allActivationReport invoked for seaching the activation report from("
						+ fromDate + "), toDate(" + toDate + ")");
		return ResponseEntity
				.ok(userMasterService.viewByFromAndToDate(LocalDate.parse(fromDate), LocalDate.parse(toDate)));
	}
}
