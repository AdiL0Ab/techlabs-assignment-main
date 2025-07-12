package com.techlabs.tictactoe;

public class Board {
	Cell [][]cell;
	
	public Board() {
		cell = new Cell[3][3];
		for(int i=0; i<3; ++i) {
			for(int j=0; j<3; ++j) {
				cell[i][j] = new Cell();
			}
		}
	}
	
	public boolean isBoardFull() {
		for(int i=0; i<3; ++i) {
			for(int j=0; j<3; ++j) {
				if(cell[i][j].isEmpty())
					return false;
			}
		}
		return true;
	}
	
	public void setCellMark(int row, int col, MarkType mark) throws CellAlreadyMarkedException {
		cell[row][col].setMark(row, col, mark);
	}
}
