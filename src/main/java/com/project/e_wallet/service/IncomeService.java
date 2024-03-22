package com.project.e_wallet.service;

import java.util.List;

import com.project.e_wallet.entity.Income;

public interface IncomeService {
	Income getIncomeById(Long id);
    List<Income> getAllIncomes();
    Income saveOrUpdateIncome(Income income);
    void deleteIncome(Long id);
}
