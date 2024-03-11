package com.project.e_wallet.service;

import java.util.List;

import com.project.e_wallet.entity.User;

public interface UserService {

	public void saveOrUpdateUser(User theuser);

	public List<User> findAll();
	
	User getUserById(Long id);
	
	void deleteUser(Long id);
}
