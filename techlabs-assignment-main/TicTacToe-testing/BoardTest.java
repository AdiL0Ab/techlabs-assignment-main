import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {
	
	Board board;
	
	@BeforeEach
	void init() {
		board = new Board();
	}
	
	@Test
	void tsetIsBoardFull() throws CellAlreadyMarkedException, InvalidCellException {
		Cell[][] cells = board.getCell();
		for(int i=0; i<3; ++i)
			for(int j=0; j<3; ++j) 
				cells[i][j].setMark(i, j, MarkType.X);
		assertTrue(board.isBoardFull());
	}
	
	@Test
	void testSetCellMark() throws CellAlreadyMarkedException, InvalidCellException {
		board.setCellMark(0, 0, MarkType.X);
		
		Cell[][] cells = board.getCell();
		assertEquals(cells[0][0].getMark(), MarkType.X);
		assertThrows(InvalidCellException.class, ()->board.setCellMark(1, 4, MarkType.X));
	}

}
