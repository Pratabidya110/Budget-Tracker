package com.mphasis.pratabidya.budgettracker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BudgetTracker {

	static List<Double> monthlyBudgets = new ArrayList<Double>();
	static List<Expense> expenseList = new ArrayList<Expense>();
	private static int expenseIdCounter = 1;
	
	public static void setMonthlyBudget(Scanner sc) { 
		
		
		if (monthlyBudgets.size()>0) { 
			System.out.println("MONTHLY BUDGET IS ALREADY SET. DO YOU WANT TO UPDATE ? [(Y : YES | N: NO)]"); 
			String choice = sc.next(); 
			if (choice.equalsIgnoreCase("Y")) { 
				System.out.println("ENTER THE MONTHLY BUDGET AMOUNT FOR EVERY MONTH: - ");
				monthlyBudgets.clear();
				double amountUpdate = sc.nextDouble();
				monthlyBudgets.add(amountUpdate); 
				System.out.println("YOUR MONTHLY BUDGET HAS BEEN UPDATED SUCCESSFULLY!"); 
				} else { 
					System.out.println("MONTHLY BUDGET NOT UPDATED."); 
					} 
			} else {
				System.out.println("ENTER THE MONTHLY BUDGET AMOUNT FOR EVERY MONTH: - ");
				double amount = sc.nextDouble();
				monthlyBudgets.add(amount); 
				System.out.println("YOUR MONTHLY BUDGET HAS BEEN UPDATED SUCCESSFULLY!");
			}
		}

	public static void setRecordExpenses(Scanner sc) {
		System.out.println("CHOOSE THE EXPENSE CATEGORY");
		System.out.println("1. CLOTHES");
		System.out.println("2. ELECTRICITY BILL");
		System.out.println("3. EXAM FEES");
		System.out.println("4. FOOD");
		System.out.println("5. FUEL");
		System.out.println("6. HOUSE RENT");
		System.out.println("7. TRAVELLING");
		System.out.println("8. OTHER");
		
		int choice = sc.nextInt();
		
		String category = "";
		
		switch(choice) {
		
		case 1:
			category = "CLOTHES";
			break;
			
		case 2:
			category = "ELECTRICITY BILL";
			break;
			
		case 3:
			category = "EXAM FEES";
			break;
			
		case 4:
			category = "FOOD";
			break;
		
		case 5:
			category = "FUEL";
			break;
			
		case 6:
			category = "HOUSE RENT";
			break;
		
		case 7:
			category = "TRAVELLING";
			break;
		
		case 8:
			category = "OTHER";
			break;
			
		default:
			System.out.println("Invalide Choice");
		}
		
		System.out.println("ENTER EXPENSE AMOUNT- "); 
		double amountExpense = sc.nextDouble(); 
		sc.nextLine();
		System.out.println("ENTER YOUR PASSWORD- "); 
		String password = sc.nextLine();
		
		
		//fetch today date
		LocalDate today = LocalDate.now(); 
		
		// Convert the date to a string in dd-MM-yyyy format 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
		String todayDate = today.format(formatter);
		
		expenseList.add(new Expense(expenseIdCounter++, todayDate , category, amountExpense, category));
		if(expenseList.size()>0) {
			System.out.println("EXPENSE RECORDED SUCCESSFULLY!");
			expenseList.forEach(i -> System.out.println(i));
		}
		
	}

	public static void setLog(Scanner sc) {
		System.out.println("1. DATE-WISE LOG");
		System.out.println("2. MONTH-WISE LOG");
		System.out.println("3. TOTAL BUDGET");
		System.out.println("4. DELETE BUDGETARY LOG");
		System.out.print("SELECT THE BUDGET LOG YOU WANT TO DISPLAY - ");
		int choice = sc.nextInt();
		sc.nextLine();
		
		switch (choice) {
			case 1:
				System.out.println("ENTER THE DATE IN DD-MM-YYYY FORMAT FOR WHICH YOU WANT TO DISPLAY THE BUDGETARY LOGS -");
				String dateCheck = sc.nextLine();
				if(dateCheck!="") {
				displayDateWiseLog(dateCheck);
				}else {
					dateCheck = sc.nextLine();
				}
				break;
			case 2:
				System.out.println("ENTER THE MONTH NUMBER BETWEEN 1 TO 12 FOR WHICH YOU WANT TO DISPLAY THE BUDGETARY LOGS");
				int month = sc.nextInt();
				displayMonthWiseLog(month);
				break;
			case 3:
				totalBudgetCheck();
				break;
			case 4:
				
				default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
				
		}
		
		
	}

	private static void totalBudgetCheck() {
		double currentBudget = 0.0;
		double spending = 0.0;
		
		if(expenseList.size()>0) {
		for(Expense e: expenseList) {
			spending = spending+ e.getAmount();
		}
			currentBudget = monthlyBudgets.get(0) - spending;
		}
		
		int width = 55; // Format the values to fit within the box 
		
		String monthlyBudgetString = String.format("| MONTHLY BUDGET: %-31s   |", monthlyBudgets.get(0)); 
		String currentBudgetString = String.format("| CURRENT BUDGET: %-31s   | ", currentBudget);
		String spendingString = String.format("| TOTAL SPENDING: %-31s   |", spending); 
		System.out.println("+" + "-".repeat(width - 2) + "+"); 
		System.out.println("|" + " ".repeat(width - 2) + "|"); 
		System.out.println("|" + " ".repeat(width - 2) + "|"); 
		System.out.println(monthlyBudgetString); 
		System.out.println(currentBudgetString); 
		System.out.println(spendingString); 
		System.out.println("|" + " ".repeat(width - 2) + "|"); 
		System.out.println("|" + " ".repeat(width - 2) + "|"); 
		System.out.println("+" + "-".repeat(width - 2) + "+");
}

	private static void displayMonthWiseLog(int month) {
		System.out.println("Need to Implement");
			
	}

	private static void displayDateWiseLog(String dateCheck) {
		List<Expense> dateWiseExpenseList = new ArrayList<Expense>();
		
		
		dateWiseExpenseList = expenseList.stream()
								 .filter(e -> e.getDate().equals(dateCheck))
								 .toList();
		System.out.println("Printing dateWiseExpenseList ================> "+dateWiseExpenseList);
		
		if(!dateWiseExpenseList.isEmpty()) {
			System.out.println("==============================================================================================================================");
			System.out.println("	ID			DATE			CATEGORY			AMOUNT			DESCRIPTION		");
			System.out.println("==============================================================================================================================");

		for(Expense expense : dateWiseExpenseList) {
			System.out.println("	"+expense.getId()+"			"+expense.getDate()+"			"+expense.getCategory()+"			"+expense.getAmount()+"			"+ expense.getDescription());
		}
			System.out.println("==============================================================================================================================");
		}
	}
}
