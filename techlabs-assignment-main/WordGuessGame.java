package com.techlabs.assignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class WordGuessGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String words[] = {"apple", "banana", "grapes", "mango", "kiwi", "orange"};
		int playAgain = 0;
		do {
			guessRamdomWord(words, scanner);
			System.out.println("\nWant to play again? PRESS (1) for YES or (0) for NO.");
			playAgain = scanner.nextInt();
		}
		while(playAgain == 1);
		
		System.out.println("Thank You for playing!");
	}
	
	private static void guessRamdomWord(String []words, Scanner scanner) {
		Random random = new Random();
		int len = words.length;
		int index = random.nextInt(len);
		String word = words[index];
		int wordLength = word.length();
		
		StringBuilder guessWord = new StringBuilder(wordLength);
		for(int i=0; i<wordLength; ++i)
			guessWord.append('_');
		
		Map<Character, ArrayList<Integer>> map = getIndexes(word);
		
		if(playGame(scanner, word, map, guessWord)) {
			System.out.println("You Won the game!");
			return;
		}
		System.out.println("All life used!\t You Lost the game!");
	}
	
	private static boolean playGame(Scanner scanner, String word, Map<Character, ArrayList<Integer>> map, StringBuilder guessWord) {
		int wordLength = word.length(), life = wordLength, correctGuess = 0;
		String userGuess="";
		
		System.out.println("System Guess:- " + word);
		while(correctGuess < wordLength && life != 0) {
			System.out.println("Guess a alphabet from a to z");
			userGuess = scanner.next();
			Character character = userGuess.charAt(0);
			if(validate(character, map, guessWord) == false) {
				life--;
			}else {
				correctGuess++;
			}
			System.out.println("Current word:- " + guessWord);
			System.out.println("Life left:- " + life);
		}
		if(correctGuess == wordLength) 
			return true;
		return false;
	}
	
	private static boolean validate(Character character, Map<Character, ArrayList<Integer>> map, StringBuilder guessWord) {
		 ArrayList<Integer> targetList = map.get(character);
         if (targetList == null || targetList.isEmpty()) {
        	System.out.println("Incorrect Guess! Try again.");
            return false;
         }
         int index = targetList.get(0);
         guessWord.setCharAt(index, character);
         targetList.remove(0);
		 return true;
	}

	private static Map<Character, ArrayList<Integer>> getIndexes(String word){
		Map<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();
		int wordLength = word.length();
		for(int i=0; i<wordLength; ++i) {
			map.putIfAbsent(word.charAt(i), new ArrayList<>());
			map.get(word.charAt(i)).add(i);
		}
//		System.out.println(map);
		return map;
	}
}
