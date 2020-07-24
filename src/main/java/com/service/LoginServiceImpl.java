package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Login;
import com.entity.User;

@Service
public class LoginServiceImpl implements LoginService {

	
	
	User iSuser = null ;
	@Autowired
	UserSer userservice ;
	

	
	@Override
	@Transactional
	public User validateUser(Login login) {
		List <User>listeusers = userservice.getAllUsers();

		for (User user : listeusers) {
			
			//System.out.println("username :"+user.getNom()+" Password "+user.getPassword());
			
			if (user.getEmail().equals(login.getEmail()) && user.getPassword().equals(login.getPassword())) {
				iSuser = user;
				
			}	
		}
	
		return iSuser;
	}

	@Override
	public void setUserAuth() {
		iSuser=null ;
		
	}
	
	
	
	
	
	
}