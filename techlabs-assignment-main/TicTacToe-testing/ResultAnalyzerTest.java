import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ResultAnalyzerTest {

	@Test
	void  testCheckWin() throws Exception {
		Board board = new Board();
		board.setCellMark(2, 1, MarkType.X);
		board.setCellMark(1, 1, MarkType.O);
		board.setCellMark(2, 0, MarkType.X);
		board.setCellMark(1, 0, MarkType.O);
		board.setCellMark(2, 2, MarkType.X);
		Assertions.assertTrue(ResultAnalyzer.checkWin(board, MarkType.X));
	}

}
