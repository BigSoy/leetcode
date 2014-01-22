package problems;

import java.util.Arrays;

public class NQueensII {

	boolean[][] board = null;
	int[][] allowed = null;
	int totalNum;

	private void placeQueen(int n, int rowNum) {
		if(rowNum == n) {
			totalNum++;
			return;
		}
		for (int col=0; col<n; col++) {
			if (allowed[rowNum][col] == 0) {
				board[rowNum][col] = true;
				if (rowNum < n-1) {
					for (int row=rowNum+1, i=1; row<n; row++, i++) {
						allowed[row][col]++;
						if (col-i >= 0)
							allowed[row][col-i]++;
						if (col+i < n)
							allowed[row][col+i]++;
					}
				}
				placeQueen(n, rowNum+1);
				board[rowNum][col] = false;
				if (rowNum < n-1) {
					for (int row=rowNum+1, i=1; row<n; row++, i++) {
						allowed[row][col]--;
						if (col-i >= 0)
							allowed[row][col-i]--;
						if (col+i < n)
							allowed[row][col+i]--;
					}
				}
			}
		}
	}
	
	public int totalNQueens(int n) {
		totalNum = 0;
		board = new boolean[n][n];
		allowed = new int[n][n];
		for (int i=0; i<n; i++) {
			Arrays.fill(board[i], false);
			Arrays.fill(allowed[i], 0);
		}
		placeQueen(n, 0);
        return totalNum;
    }
	
	public static void main(String[] args) {
		int n = 11;
		int result = new NQueensII().totalNQueens(n);
		System.out.println(result);
	}
	
}
