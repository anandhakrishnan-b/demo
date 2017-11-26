package com.sangam.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "User")
@JsonIgnoreProperties(value = { "passowrd", "updatedAt" }, allowGetters = true)
public class UserEntity extends AuditEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Long id;

	@Column(name = "UserName")
	@NotNull
	private String userName;
	
	@Column(name = "password")
	@NotNull
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@NotNull
	private UserRoleEntity role;
	
	private UserEntity() {}
	
	public UserEntity(String userName, String password, UserRoleEntity role) {
		this();
		this.userName=userName;
		this.password=password;
		this.role=role;
	}

	public Long getId() {
		return id;
	}


	public String getUserName() {
		return userName;
	}


	public String getPassword() {
		return password;
	}


	public UserRoleEntity getRole() {
		return role;
	}

	public void setRole(UserRoleEntity role) {
		this.role = role;
	}

}
