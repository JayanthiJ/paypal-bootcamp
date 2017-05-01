package com.communityLib.service;

import org.springframework.data.repository.CrudRepository;

import com.communityLib.domain.User;

import java.util.List;

public interface LoginRepository extends CrudRepository<User,String>{
	public List<User> findByUserName(String firstname) ;

}
