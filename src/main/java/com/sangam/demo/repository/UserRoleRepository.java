package com.sangam.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sangam.demo.entity.UserRoleEntity;


@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

}