package com.example.restfulapp.io.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.restfulapp.io.entity.UserEntity;

@Repository
@Component
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
}
