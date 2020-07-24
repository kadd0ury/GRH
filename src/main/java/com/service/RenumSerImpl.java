package com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.entity.Renum;
import com.repositories.RenumRepository;





@Service
public class RenumSerImpl  implements RenumSer {
	
	@Qualifier("RenumRepository")
	@Autowired
	private RenumRepository renumrep ;

	@Override
	@Transactional
	public List<Renum> getRenum() {
		return renumrep.findAll();
	}

	@Override
	@Transactional
	public void saveRenum(Renum renum) {
		renumrep.save(renum);
		
	}

	@Override
	@Transactional
	public Renum getRenum(long theId) {
		return renumrep.findById(theId).get();
	}

	@Override
	@Transactional
	public void deleteRenum(long theId) {
		renumrep.deleteById(theId);
	
	}

}
