package com.example.restfulapp.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restfulapp.entity.UserEntity;
import com.example.restfulapp.repository.UserRepository;
import com.example.restfulapp.model.shared.dto.UserDTO;
import com.example.restfulapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;


	@Override
	public UserDTO create(UserDTO user) {
		UserEntity userEntity= new UserEntity();
		BeanUtils.copyProperties(user, userEntity);

		// add non dto fields
		userEntity.setEncryptedPassword("test_password");
		userEntity.setUserId("test_user_id");
				
		UserEntity storedUser = userRepository.save(userEntity);
		UserDTO returnUser = new UserDTO();
		BeanUtils.copyProperties(storedUser, returnUser);
		
		return user;
	}
	
}
