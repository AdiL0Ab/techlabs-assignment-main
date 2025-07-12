

public class Cell {
	private MarkType mark;
	
	public Cell(){
		this.mark = MarkType.EMPTY;
	}
	
	public boolean isEmpty() {
		if(this.mark == MarkType.EMPTY) 
			return true;
		return false;
	}
	
	public MarkType getMark() {
		return mark;
	}
	
	public void setMark(int row, int col, MarkType mark) throws CellAlreadyMarkedException {
		if(isEmpty() == false)
			throw new CellAlreadyMarkedException(row, col, this.mark);
		this.mark = mark;
	}
}
