package com.project.e_wallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.e_wallet.dao.UserRepository;
import com.project.e_wallet.entity.User;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserRepository userRepository;
	

	@Override
    @Transactional
    public void saveOrUpdateUser(User theUser) {
        userRepository.saveOrUpdateUser(theUser);
    }

	@Override
    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

	@Override
    @Transactional
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }
}
