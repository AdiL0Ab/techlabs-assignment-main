
public class ResultAnalyzer {
	private ResultAnalyzer(){}
	
	private static final int[][] combinations = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6} // Diagonals
    };
	
	public static boolean checkWin(Board board, MarkType mark) {
		 for(int [] combination : combinations){
			 int row1 = combination[0] / 3;
	         int col1 = combination[0] % 3;
	         int row2 = combination[1] / 3;
	         int col2 = combination[1] % 3;
	         int row3 = combination[2] / 3;
	         int col3 = combination[2] % 3;
	         
	         Cell [][]cells = board.getCell();
	         Cell cell1 = cells[row1][col1];
	         Cell cell2 = cells[row2][col2];
	         Cell cell3 = cells[row3][col3];

	         if (cell1.getMark() == mark && cell2.getMark() == mark && cell3.getMark() == mark) {
	             return true;
	         }
		 }
		 return false;
	}
}
