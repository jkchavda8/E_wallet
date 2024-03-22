package com.project.e_wallet.service;

import java.util.List;

import com.project.e_wallet.entity.Expense;
import com.project.e_wallet.entity.Income;
import com.project.e_wallet.entity.User;

public interface UserService {

	public void saveOrUpdateUser(User theuser);

	public List<User> findAll();
	
	User getUserById(Long id);
	
	void deleteUser(Long id);
	
	public List<Income> findAllIncome(Long id);
	
	public List<Expense> findAllExpense(Long id);
	
	public List<Expense> findAllExpensesByMonth(Long id,int month,int year);
	
	public List<Income> findAllIncomeByMonth(Long id,int month,int year);
}
