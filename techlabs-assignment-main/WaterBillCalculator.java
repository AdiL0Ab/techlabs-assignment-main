package com.techlabs.takeinput;
import java.util.Scanner;

public class WaterBillCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int meterCharge = 75;
		int unitConsumed, unitCharge, totalAmount;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Unit Count: ");
		unitConsumed = scanner.nextInt();
		
		if(unitConsumed <= 100)
			unitCharge = unitConsumed*5;
		else if(unitConsumed <= 250)
			unitCharge = unitConsumed*10;
		else 
			unitCharge = unitConsumed*20;
		
		totalAmount = unitCharge + meterCharge;
		System.out.println("Total amount is : " + totalAmount);

	}
}
