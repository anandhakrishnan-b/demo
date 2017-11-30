package com.sangam.demo.facade.wf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sangam.demo.service.UserService;
import com.sangam.demo.vo.BaseRequestVO;
import com.sangam.demo.vo.BaseResponseVO;
import com.sangam.demo.vo.UserVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserWfFacadeImpl implements UserWfFacade {

	public static final Logger logger = LoggerFactory.getLogger(UserWfFacadeImpl.class);
	
	@Autowired
	UserService userService;


	@Override
	public BaseResponseVO<Long> save(BaseRequestVO<UserVO> userVORequest) {
		return userService.save(userVORequest);
	}

}
