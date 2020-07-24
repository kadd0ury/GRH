package com.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.entity.Dept;
import com.repositories.DeptRepository;





@Service
public class DeptSerImpl implements DeptSer {
	
	@Qualifier("DeptRepository")
	@Autowired
	private DeptRepository deptrepo ;

	@Override
	@Transactional
	public List<Dept> getAllDepts() {
		return  deptrepo.findAll();
	}

	@Override
	@Transactional
	public void saveDept(Dept dept) {
		
		deptrepo.save(dept);
		
	
		
	}

	@Override
	@Transactional
	public Dept getDept(long deptId) {
		
		return deptrepo.findById(deptId).get();
		
	}

	@Override
	@Transactional
	public void deleteDept(long deptId) {
		deptrepo.deleteById(deptId);
	
	}
	
	
	

}
