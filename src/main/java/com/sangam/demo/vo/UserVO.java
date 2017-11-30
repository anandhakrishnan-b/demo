package com.sangam.demo.vo;

import org.hibernate.validator.constraints.NotBlank;

public class UserVO {
	
	public UserVO() {
		super();
	}
	
	public UserVO(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	@NotBlank(message = "User Name can't be empty!")
	private String userName;
	@NotBlank(message = "Password can't be empty!")
	private String password;
	private  String name;
	private int type;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserVO [userName=");
		builder.append(userName);
		builder.append(", password=");
		builder.append(password);
		builder.append(", name=");
		builder.append(name);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
