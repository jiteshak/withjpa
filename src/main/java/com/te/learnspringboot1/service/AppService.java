package com.te.learnspringboot1.service;

import java.util.List;

import com.te.learnspringboot1.entity.dto.EmployeeDto;

public interface AppService {
	
	public abstract List<EmployeeDto> getEmployees();
	
	public abstract EmployeeDto getEmployees(int empoyeeId);
	
	public abstract EmployeeDto saveEmployees(EmployeeDto employeeDto);
	
	public abstract EmployeeDto updateEmployees(int empoyeeId,EmployeeDto employeeDto);
	
	public abstract boolean deleteEmployees(int empoyeeId);

}
