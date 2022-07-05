package com.te.learnspringboot1.repository;

import org.springframework.stereotype.Repository;

import com.te.learnspringboot.entity.Employee;
import com.te.learnspringboot1.entity.dto.EmployeeDto;

@Repository
public interface AppRepository {
	

	public abstract Employee getEmployees(int empoyeeId);
	
	public abstract Employee saveEmployees(Employee employee);
	
	public abstract Employee updateEmployees(int empoyeeId,Employee employee);
	
	public abstract boolean deleteEmployees(int empoyeeId);



}
