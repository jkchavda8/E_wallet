package com.project.e_wallet.dao;

import java.util.List;

import com.project.e_wallet.entity.Income;

public interface IncomeRepository {
	Income getIncomeById(Long id);
    List<Income> getAllIncomes();
    void saveOrUpdateIncome(Income income);
    void deleteIncome(Long id);
}
