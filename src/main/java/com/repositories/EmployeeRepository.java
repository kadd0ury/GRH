package com.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.entity.Employee;


@Repository("EmployeeRepository")
public interface  EmployeeRepository extends JpaRepository<Employee, Long> {
	

	@Query("select E from Employee E where E.grade =:grd")
	List <Employee> getEmployeeByGrade(@Param("grd") String grd);


	
}
