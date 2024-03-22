package com.project.e_wallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.e_wallet.dao.IncomeRepository;
import com.project.e_wallet.entity.Income;

import jakarta.transaction.Transactional;

@Service
public class IncomeServiceImp implements IncomeService{

	@Autowired
	private IncomeRepository incomeRepository;
	
	@Override
	@Transactional
    public Income getIncomeById(Long id) {
        return incomeRepository.getIncomeById(id);
    }

    @Override
    @Transactional
    public List<Income> getAllIncomes() {
        return incomeRepository.getAllIncomes();
    }

    @Override
    @Transactional
    public Income saveOrUpdateIncome(Income income) {
        return incomeRepository.saveOrUpdateIncome(income);
        
    }

    @Override
    @Transactional
    public void deleteIncome(Long id) {
        incomeRepository.deleteIncome(id);
    }
}
