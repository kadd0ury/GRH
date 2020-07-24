package com.service;

import java.util.List;

import com.entity.User;


public interface  UserSer {
	
	
	

	public List < User > getAllUsers();

    public void saveUser(User user);

    public User getUser(long userId);

    public void deleteUser(long userId);
	
	
	
	
	

}
