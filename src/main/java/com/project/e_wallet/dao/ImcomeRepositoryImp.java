package com.project.e_wallet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.e_wallet.entity.Income;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class ImcomeRepositoryImp implements IncomeRepository{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
    public Income getIncomeById(Long id) {
        return entityManager.find(Income.class, id);
    }

    @Override
    @Transactional
    public List<Income> getAllIncomes() {
        return entityManager.createQuery("FROM Income", Income.class).getResultList();
    }

    @Override
    @Transactional
    public Income saveOrUpdateIncome(Income income) {
        if (income.getId() == null) {
            entityManager.persist(income);
        } else {
            entityManager.merge(income);
        }
        return income;
    }

    @Override
    @Transactional
    public void deleteIncome(Long id) {
        Income income = entityManager.find(Income.class, id);
        if (income != null) {
            entityManager.remove(income);
        }
    }
}
