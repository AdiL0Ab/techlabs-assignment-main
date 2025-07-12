import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CellTest {
	Cell cell;
	@BeforeEach
	void init() {
		cell = new Cell();
	}
	
	@Test
	void testGetMark() {
		assertNotEquals(MarkType.X, cell.getMark());
	}
	
	@Test
	void testSetMark() throws Exception {
		cell.setMark(0, 0, MarkType.X);
		assertNotEquals(MarkType.O,cell.getMark());
	}

	@Test
	void testIsEmpty() throws Exception {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				 cell.setMark(i, j, MarkType.EMPTY);
			}
		}
		assertTrue(cell.isEmpty());
	}
}
