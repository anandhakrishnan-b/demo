package com.sangam.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sangam.demo.entity.UserEntity;
import com.sangam.demo.exception.EntityNotFoundException;
import com.sangam.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	 
 
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public @ResponseBody List<UserEntity> findAll() {
		return userService.findAll().orElseThrow(EntityNotFoundException::new);
	}
	
	@GetMapping("/{id}")
	public UserEntity findById(@PathVariable long id) {
		logger.info("id={}",id);
	    return userService.findById(id)
	            .orElseThrow(EntityNotFoundException::new);
	}
	
	@GetMapping("/name/{name}")
	public UserEntity findByName(@PathVariable String name) {
		logger.info("name={0}",name);
	    return userService.findByName(name)
	            .orElseThrow(EntityNotFoundException::new);
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public UserEntity save(@RequestBody UserEntity user) {
	    return userService.save(user).orElseThrow(EntityNotFoundException::new);
	}
	
	@PostMapping("/saveWithout")
	@ResponseStatus(HttpStatus.CREATED)
	public UserEntity saveWithout(@RequestBody UserEntity user) {
	    return userService.saveWithout(user).orElseThrow(EntityNotFoundException::new);
	}
}