package com.sangam.demo.facade.view;

import java.util.List;
import java.util.Optional;

import com.sangam.demo.entity.UserEntity;

public interface UserViewFacade {
	
	public Optional<List<UserEntity>> findAll();
	public Optional<UserEntity> findById(Long id);
	public Optional<UserEntity> findByName(String name);
}
