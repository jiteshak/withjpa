package com.te.learnspringboot1.repository.implementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.te.learnspringboot.entity.Employee;
import com.te.learnspringboot1.entity.dto.EmployeeDto;
import com.te.learnspringboot1.repository.AppRepository;

@Repository
public class AppRepositoryImplementation implements AppRepository {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Override
	public Employee getEmployees(int employeeId) {
		Employee employee = entityManager.find(Employee.class, employeeId);
		return employee;
	}

	/*
	 * Employee employee = em.find(Employee.class, 1);
	 * 
	 * em.getTransaction().begin(); employee.setNickname("Joe the Plumber");
	 * em.getTransaction().commit();
	 */

	@Override
	public Employee saveEmployees(Employee employee) {
		EntityTransaction entityTransaction  = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}

	@Override
	public Employee updateEmployees(int empoyeeId, Employee employee) {
		Employee saveEmployee = saveEmployees(employee);
		return saveEmployee;
	}

	@Override
	public boolean deleteEmployees(int empoyeeId) {
		Employee employee = getEmployees(empoyeeId);
		EntityTransaction entityTransaction  = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(employee);
		entityTransaction.commit();
		
		return false;
	}

}
