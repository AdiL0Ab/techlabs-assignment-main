package com.techlabs.assignmentWeek2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.*;  

public class TestCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		ArrayList<Customer> customers = getInput(scanner);
		display(customers);
		scanner.close();
	}
	
	private static ArrayList<Customer> getInput(Scanner scanner){
		String id = "", name="", email="", password="";
		ArrayList<Customer> customers = new ArrayList<>();
		System.out.println("Enter number of customers:");
		int n = scanner.nextInt();
		
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
		
			customers.add(new Customer(id, name, email, password));
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
	
	
	private static void display(ArrayList<Customer> customers) {
		Collections.sort(customers, (customer1 , customer2) -> customer1.getName().compareTo(customer2.getName()));
		for(Customer customer : customers) {
			System.out.println(customer);
		}
	}

}
