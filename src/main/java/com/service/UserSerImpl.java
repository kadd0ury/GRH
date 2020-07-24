package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.entity.User;
import com.repositories.UserRepository;




@Service
public class UserSerImpl implements UserSer {
	
	@Qualifier("UserRepository")
	@Autowired
	private UserRepository userrepo ;

	@Override
	@Transactional
	public List<User> getAllUsers() {
		return  userrepo.findAll();
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		userrepo.save(user);
		
	
		
	}

	@Override
	@Transactional
	public User getUser(long userId) {
		
		return userrepo.findById(userId).get();
		
	}

	@Override
	@Transactional
	public void deleteUser(long userId) {
		userrepo.deleteById(userId);
	
	}
	
	
	

}
