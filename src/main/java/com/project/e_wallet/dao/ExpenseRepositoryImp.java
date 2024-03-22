package com.project.e_wallet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.e_wallet.entity.Expense;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class ExpenseRepositoryImp implements ExpenseRepository{

	@Autowired
	private EntityManager entityManager;
	
	@Override
    public Expense getExpenseById(int id) {
        return entityManager.find(Expense.class, id);
    }

    @Override
    @Transactional
    public List<Expense> getAllExpenses() {
        return entityManager.createQuery("FROM Expense ", Expense.class).getResultList();
    }

    @Override
    @Transactional
    public void saveOrUpdateExpense(Expense expense) {
        if (expense.getId() == 0) {
            entityManager.persist(expense);
        } else {
            entityManager.merge(expense);
        }
    }

    @Override
    @Transactional
    public void deleteExpense(int id) {
        Expense expense = entityManager.find(Expense.class, id);
        if (expense != null) {
            entityManager.remove(expense);
        }
    }
}
