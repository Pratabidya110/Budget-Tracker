package com.mphasis.pratabidya.budgettracker;

public class Expense {

	private int id;
	private String date;
	private String category; 
	private double amount; 
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Expense(int id, String date, String category, double amount, String description) {
		super();
		this.id = id;
		this.date = date;
		this.category = category;
		this.amount = amount;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Expense [id=" + id + ", date=" + date + ", category=" + category + ", amount=" + amount
				+ ", description=" + description + "]";
	}
}
