package com.kylin.jpa.helloworld.service;

import java.util.List;

import com.kylin.jpa.helloworld.po.User;

public interface UserDao {

	public List<User> getUsers();
	
	User getForUsername(String username);

	void createUser(User user);
}
