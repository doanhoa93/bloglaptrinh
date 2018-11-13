package com.bloglaptrinh.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomError {

	private Integer type;
	private Integer field;

//	public CustomError(Integer code) {
//		this.code = code;
//	}

	public CustomError(Integer type,Integer field) {
		this.field = field;
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

	public Integer getField() {
		return field;
	}
}
