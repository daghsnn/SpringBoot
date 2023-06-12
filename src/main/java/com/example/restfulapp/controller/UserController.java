package com.example.restfulapp.controller;

import com.example.restfulapp.entity.UserEntity;
import com.example.restfulapp.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfulapp.model.request.UserRequestModel;
import com.example.restfulapp.model.response.UserResponse;
import com.example.restfulapp.model.shared.dto.UserDTO;
import com.example.restfulapp.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService service;
	@GetMapping
	public String getUser() {
		return "User";
	}
	
	@PostMapping("/create")
	public UserResponse createUser(@RequestBody UserRequestModel userRequestModel) {
		UserResponse returnValue = new UserResponse();
		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(userRequestModel,userDTO);

		UserDTO createdUser = service.create(userDTO);
		BeanUtils.copyProperties(createdUser,returnValue);
		return returnValue;
	}
	
	@PutMapping
	public String updateUser() {
		return "Updated user";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "user deleted";
	}
}
