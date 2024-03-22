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

import com.project.e_wallet.entity.Expense;
import com.project.e_wallet.service.ExpenseService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable int id) {
        return expenseService.getExpenseById(id);
    }

    @GetMapping("/all")
    @Transactional
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @PostMapping("/save")
    @Transactional
    public String saveExpense(@RequestBody Expense expense) {
        expenseService.saveOrUpdateExpense(expense);
        return "successfully save";
    }

    @PutMapping("/update")
    @Transactional
    public Expense updateExpense(@RequestBody Expense expense) {
        expenseService.saveOrUpdateExpense(expense);
        return expenseService.getExpenseById(expense.getId());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String deleteExpense(@PathVariable int id) {
        expenseService.deleteExpense(id);
        return "delete id: "+id;
    }
}
