package com.society.employee.pojo;

import java.io.Serializable;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class ResponseMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String message;

	public ResponseMessage(String msg) {
		this.message = msg;
	}
}
