package com.techlabs.tictactoe;

@SuppressWarnings("serial")
public class CellAlreadyMarkedException extends Exception{
	private int row;
	private int col;
	private MarkType mark;
	
	
	public CellAlreadyMarkedException(int row, int col, MarkType mark) {
		this.row = row;
		this.col = col;
		this.mark = mark;
	}
	
	public String getMessage() {
		return "Cell with row " + row + " and col " + col + " already marked with " + mark;
	}
}
