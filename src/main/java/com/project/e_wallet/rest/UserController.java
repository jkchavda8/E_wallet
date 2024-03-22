package com.project.e_wallet.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.e_wallet.entity.Expense;
import com.project.e_wallet.entity.Income;
import com.project.e_wallet.entity.User;
import com.project.e_wallet.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	
	@GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/allIncome/{id}")
    public List<Income> getAllIncome(@PathVariable Long id){
    	List<Income> in = userService.findAllIncome(id);
    	return in;
    }
    
    @GetMapping("/allExpense/{id}")
    public List<Expense> getAllExpense(@PathVariable Long id){
    	List<Expense> ex = userService.findAllExpense(id);
    	return ex;
    }
    
    @GetMapping("/allExpense/{id}/{month}/{year}")
    public List<Expense> getAllExpenses(
            @PathVariable("id") Long id,
            @PathVariable("month") int month,
            @PathVariable("year") int year) {
    	List<Expense> ex = userService.findAllExpensesByMonth(id, month, year);
    	return ex;
    	
    }
    
    @GetMapping("/allIncome/{id}/{month}/{year}")
    public List<Income> getAllIncome(
            @PathVariable("id") Long id,
            @PathVariable("month") int month,
            @PathVariable("year") int year) {
    	List<Income> in = userService.findAllIncomeByMonth(id, month, year);
    	return in;
    	
    }
    
    @PostMapping("/save")
    public User createUser(@RequestBody User user) {
        userService.saveOrUpdateUser(user);
        return user;
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user) {
        userService.saveOrUpdateUser(user);
        return user;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "delete id: "+id;
    }
    
    
}
