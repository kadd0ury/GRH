package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.entity.Renum;


@Repository("RenumRepository")
public interface  RenumRepository extends JpaRepository<Renum, Long> {
	
	
	
	

}
