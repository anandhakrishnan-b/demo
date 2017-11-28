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

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "User")
@JsonIgnoreProperties(value = { "passowrd", "updatedAt" }, allowGetters = true)
public class UserEntity extends AuditEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Long id;

	@Column(name = "UserName")
	@NotBlank(message = "User Name can't be empty!")
	private String userName;
	
	@Column(name = "password")
	@NotBlank(message = "Password can't be empty!")
	private String password;
	
//	TODO - Bi-Directional Changes
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@NotNull
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private UserRoleEntity role;
	
	public UserEntity() {}
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
