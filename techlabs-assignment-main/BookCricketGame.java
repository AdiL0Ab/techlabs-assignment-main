package com.techlabs.assignmentWeek2;
import java.util.Random;
import java.util.Scanner;

public class BookCricketGame {
	
	public static class Pair<T1, T2> {
		private T1 turn;
		private T2 score;
		
		public Pair(T1 turn, T2 score) {
			this.turn = turn;
			this.score = score;
		}
		
		public T1 getTurn() {
	        return turn;
	    }

	    public T2 getScore() {
	        return score;
	    }
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String player1="", player2="";
		System.out.println("Enter player1 name.");
		player1 = scanner.next();
		System.out.println("Enter player2 name.");
		player2 = scanner.next();
		
		Pair<Integer, Integer> player1Data = getInfo(player1);
		Pair<Integer, Integer> player2Data = getInfo(player2);
		int player1Score = player1Data.getScore();
		int player1Turn = player1Data.getTurn();
		int player2Score = player2Data.getScore();
		int player2Turn = player2Data.getTurn();
		
		System.out.println(player1 + " score: " + player1Score);
		System.out.println(player1 + " turn: " + player1Turn);
		System.out.println(player2 + " score: " + player2Score);
		System.out.println(player2 + " turn: " + player2Turn+"\n");
		
		if(player1Score > player2Score) 
			System.out.println(player1 + " won!");
		else if(player2Score > player1Score) 
			System.out.println(player2 + " won!");
		else if(player1Turn < player2Turn)
			System.out.println(player1 + " won!");
		else if(player2Turn < player1Turn)
			System.out.println(player2 + " won!");
		else 
			System.out.println("There is a draw!");
		
		scanner.close();
	}
	
	private static Pair<Integer, Integer> getInfo(String name) {
		System.out.println(name);
		Random random = new Random();
		Integer turn = 0, score = 0;
		while(true) {
			turn++;
			int value = random.nextInt(300)+1;
			System.out.println("Page No. "+ value);
			int reminder = value%7;
			if(reminder == 0) break;
			score += reminder;
			System.out.println("Score "+ score);
		}
		
		Pair<Integer,Integer> data = new Pair<>(turn, score);
		return data;
	}

}
