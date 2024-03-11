package com.project.e_wallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.e_wallet.dao.ExpenseRepository;
import com.project.e_wallet.entity.Expense;

import jakarta.transaction.Transactional;

@Service
public class ExpeneServiceImp implements ExpenseService{

	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Override
	@Transactional
    public Expense getExpenseById(int id) {
        return expenseRepository.getExpenseById(id);
    }

    @Override
    @Transactional
    public List<Expense> getAllExpenses() {
        return expenseRepository.getAllExpenses();
    }

    @Override
    @Transactional
    public void saveOrUpdateExpense(Expense expense) {
        expenseRepository.saveOrUpdateExpense(expense);
    }

    @Override
    @Transactional
    public void deleteExpense(int id) {
        expenseRepository.deleteExpense(id);
    }
}
