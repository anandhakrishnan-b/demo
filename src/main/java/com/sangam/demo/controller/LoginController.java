package com.sangam.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sangam.demo.facade.wf.UserWfFacade;
import com.sangam.demo.vo.BaseRequestVO;
import com.sangam.demo.vo.BaseResponseVO;
import com.sangam.demo.vo.UserVO;

@RestController
public class LoginController {
	
	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	 
 
	@Autowired
	private UserWfFacade userWfFacade;
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	
	@PostMapping("/sign-up")
	@ResponseStatus(HttpStatus.CREATED)
	public BaseResponseVO<Long> signUp(@RequestBody BaseRequestVO<UserVO> baseRequestVO) {
	    return userWfFacade.save(baseRequestVO);
	}
}