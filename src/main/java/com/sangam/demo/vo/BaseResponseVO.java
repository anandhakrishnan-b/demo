package com.sangam.demo.vo;

import java.io.Serializable;
import java.util.Optional;

import com.sangam.demo.exception.EntityNotFoundException;

public class BaseResponseVO<T> implements Serializable{
	private static final long serialVersionUID = -4505534343619898510L;
	private T result;
	
	public BaseResponseVO() {
		super();
	}

	public BaseResponseVO(T result) {
		super();
		this.result = result;
	}

	public T getResult() {
		return Optional.ofNullable(result).orElseThrow(EntityNotFoundException::new);
	}

	public void setResult(T result) {
		this.result = result;
	}

		
}
