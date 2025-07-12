package com.techlabs.assignments;
import java.util.Scanner;
public class RideBillCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int height = 0, age = 0, amount = 0;
		String wantPhoto;
		
		System.out.println("Enter your height in cm.");
		height = scanner.nextInt();
		if(height <= 0) {
			System.out.println("Height should be greater than 0 ");
			return;
		}
		if(height <= 120) {
			System.out.println("Can't ride!");
			return;
		}
		
		System.out.println("Enter your age.");
		age = scanner.nextInt();
		if(age <= 0) {
			System.out.println("Age should be greater than 0 ");
			return;
		}
		if(age > 55) {
			System.out.println("Can't ride!");
			return;
		}
		
		if(age >= 45)
			amount += 0;
		else if(age >= 18)
			amount += 12;
		else if(age >= 12)
			amount += 7;
		else 
			amount += 5;
		
		System.out.println("Want Photo ? type yes or no");
		wantPhoto = scanner.next();
		
		if(wantPhoto.equals("yes"))
			amount += 3;
		
		System.out.println("Total bill amount = " + amount);
		
		scanner.close();
	}

}
