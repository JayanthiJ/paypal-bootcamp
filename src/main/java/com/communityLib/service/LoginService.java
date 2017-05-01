package com.communityLib.service;

import java.util.List;

import com.communityLib.domain.User;

public interface LoginService {
	
	
	public String save(User user);
	public User getUser(String id);
	
	public List<User> findByUserName(String name);
	
	public boolean validate(User User,String pwd);
	
}
