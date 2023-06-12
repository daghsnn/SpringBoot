package com.example.restfulapp.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.restfulapp.entity.UserEntity;
import com.example.restfulapp.repository.UserRepository;
import com.example.restfulapp.model.shared.dto.UserDTO;
import com.example.restfulapp.service.UserService;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public UserDTO create(UserDTO user) {
		if (userRepository.findByEmail(user.getEmail()) != null) {
			throw  new RuntimeException("Kullanici zaten var lo");
		}

		UserEntity userEntity= new UserEntity();
		BeanUtils.copyProperties(user, userEntity);

		userEntity.setUserId(UUID.randomUUID().toString());
		// Secure Spring ekledik burdan da encode ediyor fakat bu classi neden main e ekledi anlamadım
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		UserEntity storedUser = userRepository.save(userEntity);
		UserDTO returnUser = new UserDTO();
		BeanUtils.copyProperties(storedUser, returnUser);
		
		return returnUser;
	}
	//UserService e extend UserDetailsService verince bunu ezmesi gerekiyor
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		return null;
	}
}
