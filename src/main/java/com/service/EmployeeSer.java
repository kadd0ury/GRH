package com.service;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.entity.*;

public interface  EmployeeSer {
	
	
	
	public List < Employee > getEmployees();

    public void saveEmployee(Employee theEmployee);

    public Employee getEmployee(long theId);

    public void deleteEmployee(long theId);
    
    List <Employee> getEmployeeByGrade(@Param("grd") String grd);
	
	
	

}
