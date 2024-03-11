package com.project.e_wallet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.e_wallet.entity.User;

import jakarta.persistence.EntityManager;


@Repository
public class UserRepositoryImp implements UserRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Override
    public void saveOrUpdateUser(User theUser) {
        entityManager.merge(theUser);
    }

	@Override
	public List<User> findAll() {
        return entityManager.createQuery("FROM User", User.class)
        .getResultList();
	}
	
	@Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
