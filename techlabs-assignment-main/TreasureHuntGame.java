package com.techlabs.takeinput;
import java.util.Scanner;

public class TreasureHuntGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String input; 
		
		System.out.println("Welcome to Treasure Island.\nYour mission is to find the Treasure\n");
		
		
		System.out.println("Choose left or right.");
		input = scanner.nextLine();

		if(!input.equals("left")) {
			System.out.println(" Fall from a hole.\nGame over");
			return;
		}
		
		
		System.out.println("Choose swim or wait.");
		input = scanner.nextLine();
		if(!input.equals("wait")) {
			System.out.println("Attack by trout.\nGame over");
			return;
		}
		
		
		System.out.println("Which door red, yellow or blue.");
		input = scanner.nextLine();
		if(input.equals("red")) 
			System.out.println("Burned by fire.\nGame over");
		else if(input.equals("blue")) 
			System.out.println("Eaten by beasts.\nGame over");
		else if(input.equals("yellow")) 
			System.out.println("You win!!");
		else
			System.out.println("Game over");
		
	}

}
