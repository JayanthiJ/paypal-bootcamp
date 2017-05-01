package com.communityLib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communityLib.domain.User;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepository loginRepository;

	@Override
	public List<User> findByUserName(String name) {

		List<User> users = loginRepository.findByUserName(name);
		return users;
	}

	@Override
	public boolean validate(User user, String pwd) {
		// TODO Auto-generated method stub
		boolean flag = false;
		if (user.getPassword().equalsIgnoreCase(pwd))
			flag = true;
		return flag;

	}

	@Override
	public String save(User user) {
		// TODO Auto-generated method stub
		loginRepository.save(user);
		return "success";
	}

	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		return loginRepository.findOne(id);

	}

}
