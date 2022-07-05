package com.te.learnspringboot1.controller;

public class EmployeeNotFoundException extends RuntimeException {
	

	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
