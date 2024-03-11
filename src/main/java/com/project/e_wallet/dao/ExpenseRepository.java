package com.project.e_wallet.dao;

import java.util.List;

import com.project.e_wallet.entity.Expense;

public interface ExpenseRepository {
	Expense getExpenseById(int id);
    List<Expense> getAllExpenses();
    void saveOrUpdateExpense(Expense expense);
    void deleteExpense(int id);
}
