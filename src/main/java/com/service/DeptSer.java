package com.service;

import java.util.List;
import com.entity.Dept;


public interface  DeptSer {
	
	
	

	public List < Dept > getAllDepts();

    public void saveDept(Dept dept);

    public Dept getDept(long deptId);

    public void deleteDept(long deptId);
	
	
	
	
	

}
