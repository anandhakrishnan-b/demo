package com.sangam.demo.service;

import java.util.List;

import com.sangam.demo.entity.UserEntity;
import com.sangam.demo.vo.BaseRequestVO;
import com.sangam.demo.vo.BaseResponseVO;
import com.sangam.demo.vo.UserVO;

public interface UserService {
	
	public BaseResponseVO<List<UserEntity>> findAll();
	public BaseResponseVO<UserEntity> findById(Long id);
	public BaseResponseVO<UserEntity> findByName(String name);
	public BaseResponseVO<Long> save(BaseRequestVO<UserVO> userVORequest);
	
}
