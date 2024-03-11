package com.project.e_wallet.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.e_wallet.entity.Income;
import com.project.e_wallet.service.IncomeService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/incomes")
public class IncomeController {

	@Autowired
	private IncomeService incomeService;
	
	@GetMapping("/{id}")
	@Transactional
    public Income getIncomeById(@PathVariable Long id) {
        return incomeService.getIncomeById(id);
    }

    @GetMapping("/all")
    @Transactional
    public List<Income> getAllIncomes() {
        return incomeService.getAllIncomes();
    }

    @PostMapping("/save")
    @Transactional
    public Income saveIncome(@RequestBody Income income) {
        incomeService.saveOrUpdateIncome(income);
        return income;
    }

    @PutMapping("/update")
    @Transactional
    public void updateIncome(@RequestBody Income income) {
        incomeService.saveOrUpdateIncome(income);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteIncome(@PathVariable Long id) {
        incomeService.deleteIncome(id);
    }
}
