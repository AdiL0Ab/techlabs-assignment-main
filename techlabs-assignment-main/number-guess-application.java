package com.techlabs.assignments;
import java.util.Scanner;
import java.lang.Math;

public class NumberGuessApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		final int totalLifeLine = 10;
		boolean playAgain = false;
		
		
		do {
			int systemGuess = (int) (Math.random()*100);
			int usedlifeLine = 1;
			boolean wonGame = false;
			System.out.println("Guess a number from 1 to 100.");
			
			while(usedlifeLine <= totalLifeLine) {
				int playerGuess = scanner.nextInt();
				if(playerGuess == systemGuess) {
					wonGame = true;
					break;
				}
				usedlifeLine++;
				if(usedlifeLine <= totalLifeLine) {
					if(playerGuess < systemGuess)
						System.out.println("Sorry, Too low. Guess Again.");
					else
						System.out.println("Sorry, Too high. Guess Again.");
				}
			}
			
			if(wonGame) 
				System.out.println("You won using "+usedlifeLine+" Lifeline.");
			else
				System.out.println("You lost the game. All lifeline used.");
			
			System.out.println("\nWant to play again? Press 1.Yes or 0.NO");
			int userFlag = scanner.nextInt();
			
			if(userFlag == 1) 
				playAgain = true;
			else 
				playAgain = false;
			
		}while(playAgain);
		
		scanner.close();

	}

}
