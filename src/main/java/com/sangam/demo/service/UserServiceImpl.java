package com.sangam.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangam.demo.entity.UserEntity;
import com.sangam.demo.entity.UserRoleEntity;
import com.sangam.demo.repository.UserRepository;
import com.sangam.demo.repository.UserRoleRepository;

@Service
public class UserServiceImpl implements UserService {

	public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Override
	public Optional<List<UserEntity>> findAll() {
		return Optional.ofNullable(userRepository.findAll());
	}

	@Override
	public Optional<UserEntity> findById(Long id) {
		return Optional.ofNullable(userRepository.findOne(id));
	}

	@Override
	public Optional<UserEntity> findByName(String name) {
		return Optional.of(userRepository.findByName(name));
	}

	@Override
	public Optional<UserEntity> saveWithout(UserEntity user) {
		logger.debug( "NO>>trasaction stats here");
		userRoleRepository.save(user.getRole());
		return Optional.of(userRepository.save(user));
	}
	
	
	@Override
	public Optional<UserEntity> save(UserEntity user) {
		logger.debug( "trasaction stats here");
		userRoleRepository.save(user.getRole());
		UserEntity userSaved = userRepository.save(user);
		logger.debug( "trasaction ends here");
		return Optional.of(userSaved);
	}

}
