package com.techlabs.inheritance;

import java.util.Scanner;

public class TestCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Car []cars = getCars(scanner);
		showCars(cars);
		scanner.close();
	}
	
	private static Car[] getCars(Scanner scanner) {
		System.out.println("Enter number of cars:");
		int len = scanner.nextInt();
		String name="";
		double milage, price; 
		Car []cars = new Car[len];
		for(int i=0; i<len; ++i) {
			System.out.println("Enter car name:");
			name = scanner.next();
			System.out.println("Enter car milage:");
			milage = scanner.nextDouble();
			System.out.println("Enter car price:");
			price = scanner.nextDouble();
			cars[i] = new Car(name,milage,price);
		}
		return cars;
	}
	
	private static void showCars(Car[] cars) {
		System.out.println("\nAll cars details");
		int len = cars.length;
		for(int i=0; i<len; ++i) {
			cars[i].displayDetails();
		}
	}

}
