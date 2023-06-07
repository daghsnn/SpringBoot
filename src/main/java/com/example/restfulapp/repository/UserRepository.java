package com.example.restfulapp.repository;

import org.springframework.data.repository.CrudRepository;


import com.example.restfulapp.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
}
