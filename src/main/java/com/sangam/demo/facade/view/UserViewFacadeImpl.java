package com.sangam.demo.facade.view;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sangam.demo.entity.UserEntity;
import com.sangam.demo.service.UserService;
import com.sangam.demo.vo.BaseResponseVO;

@Service
@Transactional(readOnly = true)
public class UserViewFacadeImpl implements UserViewFacade {

	public static final Logger logger = LoggerFactory.getLogger(UserViewFacadeImpl.class);
	
	@Autowired
	UserService userService;

	@Override
	public BaseResponseVO<List<UserEntity>> findAll() {
		return userService.findAll();
	}

	@Override
	public BaseResponseVO<UserEntity> findById(Long id) {
		return userService.findById(id);
	}

	@Override
	public BaseResponseVO<UserEntity> findByName(String name) {
		return userService.findByName(name);
	}

}
