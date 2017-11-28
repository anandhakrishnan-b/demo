package com.sangam.demo.facade.wf;

import java.util.Optional;

import com.sangam.demo.entity.UserEntity;

public interface UserWfFacade {
	
	public Optional<UserEntity> save(UserEntity user);
	public Optional<UserEntity> saveWithout(UserEntity user);
	
}
