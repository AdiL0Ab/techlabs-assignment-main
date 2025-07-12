

public class Board {
	Cell [][]cells;
	
	public Board() {
		cells = new Cell[3][3];
		for(int i=0; i<3; ++i) {
			for(int j=0; j<3; ++j) {
				cells[i][j] = new Cell();
			}
		}
	}
	
	public Cell[][] getCell() {
		return cells;
	}

	public void setCell(Cell[][] cell) {
		this.cells = cell;
	}
	
	public void setCellMark(int row, int col, MarkType mark) throws CellAlreadyMarkedException, InvalidCellException {
		if(row<0 || row >=3 || col<0 || col>=3)
			throw new InvalidCellException();
		cells[row][col].setMark(row, col, mark);
	}
	
	public boolean isBoardFull() {
		for(int i=0; i<3; ++i) {
			for(int j=0; j<3; ++j) {
				if(cells[i][j].isEmpty())
					return false;
			}
		}
		return true;
	}
}
