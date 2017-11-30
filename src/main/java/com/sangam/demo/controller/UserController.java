package com.sangam.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangam.demo.entity.UserEntity;
import com.sangam.demo.facade.view.UserViewFacade;
import com.sangam.demo.facade.wf.UserWfFacade;
import com.sangam.demo.vo.BaseResponseVO;

@RestController
@RequestMapping("/users")
public class UserController {
	
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	 
 
	@Autowired
	private UserWfFacade userWfFacade;
	
	@Autowired
	private UserViewFacade userViewFacade;
	
	@GetMapping("/")
	public BaseResponseVO<List<UserEntity>> findAll() {
		return userViewFacade.findAll();
	}
	
	@GetMapping("/{id}")
	public BaseResponseVO<UserEntity> findById(@PathVariable long id) {
		logger.info("id={}",id);
	    return userViewFacade.findById(id);
	}
	
	@GetMapping("/name/{name}")
	public BaseResponseVO<UserEntity> findByName(@PathVariable String name) {
		logger.info("name={0}",name);
	    return userViewFacade.findByName(name);
	}
	
}