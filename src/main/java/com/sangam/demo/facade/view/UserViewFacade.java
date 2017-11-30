package com.sangam.demo.facade.view;

import java.util.List;

import com.sangam.demo.entity.UserEntity;
import com.sangam.demo.vo.BaseResponseVO;

public interface UserViewFacade {
	
	public BaseResponseVO<List<UserEntity>> findAll();
	public BaseResponseVO<UserEntity> findById(Long id);
	public BaseResponseVO<UserEntity> findByName(String name);
}
