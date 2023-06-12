package com.example.restfulapp.service;

import com.example.restfulapp.model.shared.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public interface UserService extends UserDetailsService {
	UserDTO create(UserDTO user);
}
