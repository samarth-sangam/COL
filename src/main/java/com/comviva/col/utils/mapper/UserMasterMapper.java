/**
 * 
 */
package com.comviva.col.utils.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.comviva.col.entity.UserMaster;
import com.comviva.col.utils.dto.UserMasterDto;
import com.comviva.col.utils.responseobjects.UserMasterResponse;

/**
 * @author samarth.sangam
 *
 */
public class UserMasterMapper {

	@Autowired
	private ModelMapper modelMapper = new ModelMapper();

	public UserMaster toEntity(UserMasterDto userMasterDto) {
		UserMaster userMaster = new UserMaster();

		if (userMasterDto.getEmail() != null) {
			userMaster.setEmail(userMasterDto.getEmail());
		}

		if (userMasterDto.getMobileNumber() != null) {
			userMaster.setMobileNumber(userMasterDto.getMobileNumber());
		}

		if (userMasterDto.getParentId() != null) {
			userMaster.setParentId(userMasterDto.getParentId());
		}

		if (userMasterDto.getPassword() != null) {
			userMaster.setPassword(userMasterDto.getPassword());
		}

		if (userMasterDto.getType() != null) {
			userMaster.setType(userMasterDto.getType());
		}

		if (userMasterDto.getUsername() != null) {
			userMaster.setUsername(userMasterDto.getUsername());
		}
		if (userMasterDto.getLocation() != null) {
			userMaster.setLocation(userMasterDto.getLocation());
		}
		return userMaster;
	}

	public UserMasterDto toDto(UserMaster userMaster) {
		UserMasterDto userMasterDto = new UserMasterDto();

		if (userMaster.getEmail() != null) {
			userMasterDto.setEmail(userMaster.getEmail());
		}

		if (userMaster.getMobileNumber() != null) {
			userMasterDto.setMobileNumber(userMaster.getMobileNumber());
		}

		if (userMaster.getParentId() != null) {
			userMasterDto.setParentId(userMaster.getParentId());
		}

		if (userMaster.getPassword() != null) {
			userMasterDto.setPassword(userMaster.getPassword());
		}

		if (userMaster.getType() != null) {
			userMasterDto.setType(userMaster.getType());
		}

		if (userMaster.getUsername() != null) {
			userMasterDto.setUsername(userMaster.getUsername());
		}
		if (userMaster.getLocation() != null) {
			userMasterDto.setLocation(userMaster.getLocation());
		}
		return userMasterDto;
	}

	public UserMaster toEntity(UserMasterDto userMasterDto, int id) {
		UserMaster userMaster = this.toEntity(userMasterDto);
		userMaster.setUserId(id);
		return userMaster;
	}

	public UserMasterResponse toResponse(UserMaster userMaster) {
		return modelMapper.map(userMaster, UserMasterResponse.class);

	}
}
