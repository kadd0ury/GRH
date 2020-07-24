package com.service;

import com.entity.Login;
import com.entity.User;

public interface LoginService {

	public User validateUser(Login login);
	public void setUserAuth();

}
