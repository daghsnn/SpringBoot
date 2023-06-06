package com.example.restfulapp.service;

import com.example.restfulapp.model.shared.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
	UserDTO create(UserDTO user);
}
