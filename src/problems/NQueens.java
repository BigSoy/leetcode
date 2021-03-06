package problems;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {

	boolean[][] board = null;
	int[][] allowed = null;
	ArrayList<String[]> result = null;

	private void placeQueen(int n, int rowNum) {
		if(rowNum == n) {
			String[] solution = new String[n];
			for(int i=0; i<n; i++) {
				StringBuffer sb = new StringBuffer();
				for(int j=0; j<n; j++) {
					sb.append(board[i][j] ? 'Q' : '.');
				}
				solution[i] = sb.toString();
			}
			result.add(solution);
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
	
	public ArrayList<String[]> solveNQueens(int n) {
		result = new ArrayList<String[]>();
		board = new boolean[n][n];
		allowed = new int[n][n];
		for (int i=0; i<n; i++) {
			Arrays.fill(board[i], false);
			Arrays.fill(allowed[i], 0);
		}
		placeQueen(n, 0);
        return result;
    }
	
	public static void main(String[] args) {
		int n = 4;
		ArrayList<String[]> result = new NQueens().solveNQueens(n);
		int size = result.size();
		for (int i=0; i<size; i++) {
			System.out.println("Solution " + (i+1) + ":");
			for (int j=0; j<n; j++) {
				System.out.println(result.get(i)[j]);
			}
		}
	}
	
}
