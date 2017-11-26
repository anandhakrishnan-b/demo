package com.sangam.demo.service;

import java.util.List;
import java.util.Optional;

import com.sangam.demo.entity.UserEntity;

public interface UserService {
	
	public Optional<List<UserEntity>> findAll();
	public Optional<UserEntity> findById(Long id);
	public Optional<UserEntity> findByName(String name);
	public Optional<UserEntity> save(UserEntity user);
	public Optional<UserEntity> saveWithout(UserEntity user);
	
}
