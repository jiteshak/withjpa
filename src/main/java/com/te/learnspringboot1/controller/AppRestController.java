package com.te.learnspringboot1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.learnspringboot1.entity.dto.EmployeeDto;
import com.te.learnspringboot1.service.AppService;

import come.te.learnspringboot1.response.GenralResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/c1")
@RequiredArgsConstructor
public class AppRestController {

	private final AppService appService;

	@GetMapping(path = "/employees")
	public ResponseEntity<GenralResponse> getEemployee() {
		return ResponseEntity.ok().body(new GenralResponse(HttpStatus.OK, null, "Success!", "List of Employee"));
	}

	@GetMapping(path = "/employee/{employeeId}")
	public ResponseEntity<GenralResponse> getEmployee(@PathVariable int employeeId) {
		EmployeeDto employeeDto = appService.getEmployees(employeeId);
		if (employeeDto != null) {
			return ResponseEntity.ok().body(new GenralResponse(HttpStatus.OK, null, "Provided!", employeeDto));
		}
		
		throw new EmployeeNotFoundException(
				"Employee with given employeeId " + employeeId +" is not present in dattabase");
				
		
		/*
		 * return ResponseEntity.badRequest() .body(new
		 * GenralResponse(HttpStatus.BAD_REQUEST, "Data not Found!", null, null));
		 */
	}

	@PostMapping(path = "/employee")
	public ResponseEntity<GenralResponse> saveEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto saveEmployees = appService.saveEmployees(employeeDto);
		return ResponseEntity.ok().body(new GenralResponse(HttpStatus.OK, null, "Saved Success!", employeeDto));
	}

	@PutMapping(path = "/employee/{employeeId}")
	public ResponseEntity<GenralResponse> updateEmployee(@PathVariable int employeeId,
			@RequestBody EmployeeDto employeeDto) {
		EmployeeDto updateEmployees = appService.updateEmployees(employeeId, employeeDto);
		return ResponseEntity.ok().body(new GenralResponse(HttpStatus.OK, null, "Success!", "Updated employee data"));
	}

	@DeleteMapping(path = "/employee/{employeeId}")
	public ResponseEntity<GenralResponse> deleteEmployee(@PathVariable int employeeId) {
		boolean deleteEmployees = appService.deleteEmployees(employeeId);
		return ResponseEntity.ok().body(new GenralResponse(HttpStatus.OK, null, "Success!", " Deleted employee data"));
	}
}
