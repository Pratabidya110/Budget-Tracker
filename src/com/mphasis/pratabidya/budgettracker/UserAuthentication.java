package com.mphasis.pratabidya.budgettracker;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserAuthentication {

private static Map<String, String> userMap = new HashMap<String, String>();
	
	public static void checkValidation(String userName, String password) {
		
		
		if(userMap.containsKey(userName)) {
				if(authenticate(userName,password)) {
					displayMenu();
				}else {
					System.out.println("Authentication failed!");
				}
			}else {
				userMap.put(userName, password);
				System.out.println("New User Added Successfully");
			}
			
			System.out.println(userMap);
			
			
		}
		
	
	
	public static Boolean authenticate(String userName, String password) {
		return userMap.get(userName).equalsIgnoreCase(password);
		
	}
	
	private static void displayMenu() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. SET MONTHLY BUDGET");
			System.out.println("2. RECORD AN EXPENSE");
			System.out.println("3. BUDGETARY LOGS");
			System.out.println("4. CHANGE PASSWORD");
			System.out.println("5. EXIT");
			System.out.println("CHOOSE AN OPTION: ");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				
				BudgetTracker.setMonthlyBudget(sc);
				break;
				
			case 2:
				BudgetTracker.setRecordExpenses(sc);
				break;
				
			case 3: 
				BudgetTracker.setLog(sc);
				break;
			
			default:
				System.out.println("Invalid Choice. Please try again");
			}
		}
		
	}
}
