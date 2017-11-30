package com.sangam.demo.service;

import static java.util.Collections.emptyList;

import java.util.List;
import java.util.Optional;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sangam.demo.entity.UserEntity;
import com.sangam.demo.exception.EntityNotFoundException;
import com.sangam.demo.repository.UserRepository;
import com.sangam.demo.repository.UserRoleRepository;
import com.sangam.demo.vo.BaseRequestVO;
import com.sangam.demo.vo.BaseResponseVO;
import com.sangam.demo.vo.UserVO;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	Mapper beanMapper;
	
	@Override
	public BaseResponseVO<List<UserEntity>> findAll() {
		
		List<UserEntity> usersOpt = Optional.ofNullable(userRepository.findAll()).orElseThrow(EntityNotFoundException::new);
		BaseResponseVO<List<UserEntity>> baseResponse = new BaseResponseVO<List<UserEntity>>(usersOpt);
		return baseResponse;
	}

	@Override
	public BaseResponseVO<UserEntity> findById(Long id) {
		UserEntity userOpt = Optional.ofNullable(userRepository.findOne(id)).orElseThrow(EntityNotFoundException::new);
		BaseResponseVO<UserEntity> baseResponse = new BaseResponseVO<UserEntity>(userOpt);
		return baseResponse;
	}

	@Override
	public BaseResponseVO<UserEntity> findByName(String name) {
		UserEntity userOpt = Optional.ofNullable(userRepository.findByName(name)).orElseThrow(EntityNotFoundException::new);
		BaseResponseVO<UserEntity> baseResponse = new BaseResponseVO<UserEntity>(userOpt);
		return baseResponse;
		
	}

	@Override
	public BaseResponseVO<Long> save(BaseRequestVO<UserVO> userVORequest) {
		logger.debug( ">>> UserVO  save {} "   , userVORequest.getInput());
		UserEntity user = new UserEntity();
		beanMapper.map(userVORequest.getInput(), user);
//		TODO - UserEntity user = beanMapper.map(userVORequest.getInput(), UserEntity.class);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRoleRepository.save(user.getRole());
		UserEntity userSaved = userRepository.save(user);
		BaseResponseVO<Long> baseResponse = new BaseResponseVO<Long>(userSaved.getId());
		return baseResponse;
	}
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByName(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(userEntity.getUserName(), userEntity.getPassword(), emptyList());
    }

}
