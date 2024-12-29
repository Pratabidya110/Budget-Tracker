package com.mphasis.pratabidya.budgettracker;

import java.util.Scanner;

public class BudgetTrackerMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("+---------------------------+");
		System.out.println("| WELCOME TO BUDGET TRACKER |");
		System.out.println("+---------------------------+");
		System.out.println("PLEASE LOGIN TO CONTINUE");
		
		while(true) {
			System.out.println("USERNAME: ");
			String userName = sc.nextLine();
			System.out.println("PASSWORD: ");
			String password = sc.nextLine();
			
			User user = new User(userName,password);
			
		}

	}

}
