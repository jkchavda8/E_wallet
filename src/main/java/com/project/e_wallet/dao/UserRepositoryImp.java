package com.project.e_wallet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.e_wallet.entity.Expense;
import com.project.e_wallet.entity.Income;
import com.project.e_wallet.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


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
    
    @Override
    public List<Income> findAllIncome(Long id){
    	TypedQuery<Income> query = entityManager.createQuery(
                "SELECT i FROM Income i WHERE i.user.id = :userId", Income.class);
            query.setParameter("userId", id);
            return query.getResultList();
    }
    
    @Override
    public List<Expense> findAllExpense(Long id){
    	TypedQuery<Expense> query = entityManager.createQuery(
                "SELECT i FROM Expense i WHERE i.user.id = :userId", Expense.class);
            query.setParameter("userId", id);
            return query.getResultList();
    }

	@Override
	public List<Expense> findAllExpensesByMonth(Long id, int month, int year) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("SELECT e FROM Expense e WHERE e.user.id = :userId AND MONTH(e.date) = :month AND YEAR(e.date) = :year", Expense.class)
                .setParameter("userId", id)
                .setParameter("month", month)
                .setParameter("year", year)
                .getResultList();
	}
	
	@Override
	public List<Income> findAllIncomeByMonth(Long id, int month, int year) {
	    return entityManager.createQuery("SELECT i FROM Income i WHERE i.user.id = :userId AND MONTH(i.date) = :month AND YEAR(i.date) = :year", Income.class)
	            .setParameter("userId", id)
	            .setParameter("month", month)
	            .setParameter("year", year)
	            .getResultList();
	}
}
