package com.sangam.demo.facade.view;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sangam.demo.entity.UserEntity;
import com.sangam.demo.service.UserService;

@Service
@Transactional(readOnly = true)
public class UserViewFacadeImpl implements UserViewFacade {

	public static final Logger logger = LoggerFactory.getLogger(UserViewFacadeImpl.class);
	
	@Autowired
	UserService userService;

	@Override
	public Optional<List<UserEntity>> findAll() {
		// TODO Auto-generated method stub
		return userService.findAll();
	}

	@Override
	public Optional<UserEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return userService.findById(id);
	}

	@Override
	public Optional<UserEntity> findByName(String name) {
		// TODO Auto-generated method stub
		return userService.findByName(name);
	}

}
