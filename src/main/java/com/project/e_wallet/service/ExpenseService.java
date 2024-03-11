package com.project.e_wallet.service;

import java.util.List;

import com.project.e_wallet.entity.Expense;

public interface ExpenseService {
	Expense getExpenseById(int id);
    List<Expense> getAllExpenses();
    void saveOrUpdateExpense(Expense expense);
    void deleteExpense(int id);
}
