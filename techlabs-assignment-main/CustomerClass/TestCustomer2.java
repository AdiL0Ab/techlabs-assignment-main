package com.techlabs.assignmentWeek2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestCustomer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Customer[] customers = getInput(scanner);
		display(customers);
		scanner.close();

	}
	
	private static Customer[] getInput(Scanner scanner){
		String id = "", name="", email="", password="";
		System.out.println("Enter number of customers:");
		int n = scanner.nextInt();
		Customer[] customers = new Customer[n];
		
		for(int i=0; i<n; ++i) {
			System.out.println("Enter Customer Id:");
			id = scanner.next().trim();
			System.out.println("Enter Customer name:");
			name = scanner.next().trim();
			
			System.out.println("Enter Customer email:");
			do {
				email = scanner.next().trim();
			} while(checkValidEmail(email) == false);
			
			System.out.println("Enter Customer password:");
			password = scanner.next();
		
			customers[i] = new Customer(id, name, email, password);
		}
		
		return customers;
	}
	
	private static boolean checkValidEmail(String email) {
		String emailPattern = "^[A-Za-z0-9_.-]+[@][a-z]+[.][a-z]{2,3}$";
		Pattern pattern = Pattern.compile(emailPattern);
		Matcher matcher = pattern.matcher(email);
		if(matcher.matches()) 
			return true;
		System.out.println("Enter a valid Email: ");
		return false;
	}
	
	
	private static void display(Customer[] customers) {
		int len = customers.length;
		sortCustomers(customers);
		for(int i=0; i<len; ++i) {
			System.out.println(customers[i]);
		}
	}
	
	private static void sortCustomers(Customer []customers) {
		int len = customers.length;
        for (int i = 0; i < len - 1; i++) {
        	sortCustomersExtension(customers, i);
        }
	}

	private static void sortCustomersExtension(Customer []customers, int i) {
		int len = customers.length;
		for (int j = 0; j < len - i - 1; j++) {
			sortCustomersComparator(customers, i, j);
        }
	}
	
	private static void sortCustomersComparator(Customer []customers, int i, int j) {
		if(customers[j].getName().compareTo(customers[j+1].getName()) > 0) {
			Customer tempAccount = customers[j];
        	customers[j] = customers[j + 1];
        	customers[j + 1] = tempAccount;
        }
	}


}
