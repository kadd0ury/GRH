package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Dept;





@Repository("DeptRepository")
public interface DeptRepository  extends JpaRepository<Dept, Long>{

}
