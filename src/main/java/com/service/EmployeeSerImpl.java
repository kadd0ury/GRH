package com.service;

import java.util.List;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


import com.entity.Employee;
import com.repositories.EmployeeRepository;
@Service
public class EmployeeSerImpl implements EmployeeSer {
	
	
	@Qualifier("EmployeeRepository")
	@Autowired
	private EmployeeRepository employeerep;
	
	@Override
	@Transactional
	public List<Employee> getEmployees() {
		return employeerep.findAll();
	}

	@Override
	@Transactional
	public void saveEmployee(Employee theEmployee) {
		employeerep.save(theEmployee);
	
		
	}

	@Override
	@Transactional
	public Employee getEmployee(long theId) {
		return employeerep.findById(theId).get();
		

	}

	@Override
	@Transactional
	public void deleteEmployee(long theId) {
		employeerep.deleteById(theId);	
	}
	
	
	 @Override
	 @Transactional
	public List <Employee> getEmployeeByGrade(String grd){
		  
		  return employeerep.getEmployeeByGrade(grd);
		  
		  
		
		  
	  }

}
