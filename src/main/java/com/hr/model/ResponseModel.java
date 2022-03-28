package com.hr.model;

public class ResponseModel {
private Object data;
private String statusCode;
private String msg;
public ResponseModel() {
	super();
	// TODO Auto-generated constructor stub
}
public ResponseModel(Object data, String statusCode, String msg) {
	super();
	this.data = data;
	this.statusCode = statusCode;
	this.msg = msg;
}
public Object getData() {
	return data;
}
public void setData(Object data) {
	this.data = data;
}
public String getStatusCode() {
	return statusCode;
}
public void setStatusCode(String statusCode) {
	this.statusCode = statusCode;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}



}
