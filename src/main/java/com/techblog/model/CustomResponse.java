package com.techblog.model;

import com.techblog.common.constant.Constants;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomResponse {

	private int resultCode;
	private Long id;
	private Map<String, String> listMsg;
	private Set<CustomError> errors;
	private Object item;
	private List listItem;

	public CustomResponse() {
		this.resultCode = Constants.ResultCode.SUCCESS;
	}

	public CustomResponse(int resultCode, Long id, Set<CustomError> errors,Map<String, String> listMsg) {
		this.resultCode = resultCode;
		this.id = id;
		this.errors = errors;
		this.listMsg = listMsg;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<String, String> getListMsg() {
		return listMsg;
	}

	public void setListMsg(Map<String, String> listMsg) {
		this.listMsg = listMsg;
	}

	public Set<CustomError> getErrors() {
		return errors;
	}

	public void setErrors(Set<CustomError> errors) {
		this.errors = errors;
	}

	public Object getItem() {
		return item;
	}

	public void setItem(Object item) {
		this.item = item;
	}

	public List getListItem() {
		return listItem;
	}

	public void setListItem(List listItem) {
		this.listItem = listItem;
	}
	
	
}
