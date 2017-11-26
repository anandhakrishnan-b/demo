package com.sangam.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sangam.demo.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	@Query(value="from UserEntity u where u.userName = :userName ")
	UserEntity findByName(@Param("userName") String name);

}
