package com.sangam.demo.facade.wf;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sangam.demo.entity.UserEntity;
import com.sangam.demo.service.UserService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserWfFacadeImpl implements UserWfFacade {

	public static final Logger logger = LoggerFactory.getLogger(UserWfFacadeImpl.class);
	
	@Autowired
	UserService userService;

	@Override
	public Optional<UserEntity> save(UserEntity user) {
		// TODO Auto-generated method stub
		return userService.save(user);
	}

	@Override
	public Optional<UserEntity> saveWithout(UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
