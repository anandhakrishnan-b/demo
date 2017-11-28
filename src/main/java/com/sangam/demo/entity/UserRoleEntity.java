package com.sangam.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Role")
public class UserRoleEntity  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Long id;

	@Column(name = "name")
	@NotNull
	private  String name;
	
	@Column(name = "type")
	@NotNull
	private  int type;
	
	public UserRoleEntity() {}
	

	public UserRoleEntity(String name, int type) {
		this();
		this.name = name;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getType() {
		return type;
	}

	
	
	

}
