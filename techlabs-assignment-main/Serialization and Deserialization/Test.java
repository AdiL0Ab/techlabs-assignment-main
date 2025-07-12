package com.techlabs.serializationAndDeserialization;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		MovieController movieController = new MovieController(scanner);
		movieController.start();
		scanner.close();
		System.exit(0);
	}

}
