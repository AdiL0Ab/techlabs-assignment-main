package com.techlabs.tictactoe;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Board board = new Board();
		while(board.isBoardFull()==false) {
			getUserInput(scanner, board);
		}
		System.exit(0);
	}
	
	private static void getUserInput(Scanner scanner, Board board){
		System.out.println("Give row number.");
		int row = scanner.nextInt();
		System.out.println("Give col number.");
		int col = scanner.nextInt();
		System.out.println("press\n1. X \n2. O");
		int option = scanner.nextInt();
		MarkType mark;
		switch(option) {
			case 1:
				mark = MarkType.X;
				break;
			case 2:
				mark = MarkType.O;
				break;
			default:
				return;
		}
		
		try {
			board.setCellMark(row, col, mark);
		} catch (CellAlreadyMarkedException e) {
			System.out.println(e.getMessage());
		}
	}

}
