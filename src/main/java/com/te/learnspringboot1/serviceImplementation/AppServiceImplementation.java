package com.te.learnspringboot1.serviceImplementation;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.learnspringboot.entity.Employee;
import com.te.learnspringboot1.entity.dto.EmployeeDto;
import com.te.learnspringboot1.repository.AppRepository;
import com.te.learnspringboot1.service.AppService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppServiceImplementation implements AppService {

	private final AppRepository appRepository;

	@Override
	public List<EmployeeDto> getEmployees() {
		return null;
	}

	@Override
	public EmployeeDto getEmployees(int employeeId) {
		Employee employee = appRepository.getEmployees(employeeId);
		EmployeeDto employeeDto = new EmployeeDto();
		BeanUtils.copyProperties(employee, employeeDto);
		return employeeDto;

	}

	@Override
	public EmployeeDto saveEmployees(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		employee = appRepository.saveEmployees(employee);
		BeanUtils.copyProperties(employee, employeeDto);
		return employeeDto;
	}

	@Override
	public EmployeeDto updateEmployees(int empoyeeId, EmployeeDto employeeDto) {
		Employee employee = appRepository.getEmployees(empoyeeId);
		BeanUtils.copyProperties(employeeDto, employee);
		employee = appRepository.saveEmployees(employee);
		BeanUtils.copyProperties(employee, employeeDto);
		return employeeDto;
	}

	@Override
	public boolean deleteEmployees(int empoyeeId) {
		boolean isDeleted = appRepository.deleteEmployees(empoyeeId);
		return true;
	}
//	While JAX-RS annotations allows you to map classes and methods to handle HTTP requests, 
//	Jackson annotations allows you to map Java classes to JSON objects and vice versa.

}
