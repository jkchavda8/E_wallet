package com.project.e_wallet.entity;

import java.sql.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "expenses")
public class Expense {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(nullable = false)
    private Date date;

	@Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Expense() {}
    
    public Expense(int id, User user, String description, double amount, Category category, Date date) {
		super();
		this.id = id;
		this.user = user;
		this.description = description;
		this.amount = amount;
		this.category = category;
		this.date = date;
	}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

    
    @Override
	public String toString() {
		return "Expense [id=" + id + ", user=" + user + ", description=" + description + ", amount=" + amount
				+ ", category=" + category + ", date=" + date + "]";
	}
	
}
