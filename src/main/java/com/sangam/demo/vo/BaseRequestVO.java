package com.sangam.demo.vo;

import java.io.Serializable;
import java.util.Optional;

import com.sangam.demo.exception.EntityNotFoundException;

public class BaseRequestVO<T> implements Serializable{

	private static final long serialVersionUID = 1L;	
	
	private T input;

	public BaseRequestVO() {
		super();
	}

	public BaseRequestVO(T input) {
		super();
		this.input = input;
	}

	public T getInput() {
		return Optional.ofNullable(input).orElseThrow(EntityNotFoundException::new);
	}

	public void setInput(T input) {
		this.input = input;
	}
	
	
}	
