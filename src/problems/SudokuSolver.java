package problems;

public class SudokuSolver {

	private boolean[][] row = null;
	private boolean[][] col = null;
	private boolean[][] block = null;
	
	private boolean dfs(char[][] board, int x, int y) {
		if(x == 9)
			return true;
		if('.' == board[x][y]) {
			for(int i=1; i<=9; i++) {
				if(row[x][i-1] || col[y][i-1] || block[(x/3)*3+(y/3)][i-1])
					continue;
				board[x][y] = (char)('0' + i);
				row[x][i-1] = true;
				col[y][i-1] = true;
				block[(x/3)*3+(y/3)][i-1] = true;
				if(y < 8) {
					if(dfs(board, x, y+1))
						return true;
				} else{
					if(dfs(board, x+1, 0))
						return true;
				}
				board[x][y] = '.';
				row[x][i-1] = false;
				col[y][i-1] = false;
				block[(x/3)*3+(y/3)][i-1] = false;
			}
		} else {
			if(y < 8) {
				if(dfs(board, x, y+1))
					return true;
			} else{
				if(dfs(board, x+1, 0))
					return true;
			}
		}
		return false;
	}
	
	public void solveSudoku(char[][] board) {
		row = new boolean[9][9];
		col = new boolean[9][9];
		block = new boolean[9][9];
		for(int i=0; i<9; i++)
			for(int j=0; j<9; j++)
				if(board[i][j] != '.') {
					int num = board[i][j] - '0';
					row[i][num-1] = true;
					col[j][num-1] = true;
					block[(i/3)*3+(j/3)][num-1] = true;
				}
		dfs(board, 0, 0);
	}
	
	public static void main(String[] args) {
		String[] strBoard = {"..9748...",
							 "7........",
							 ".2.1.9...",
							 "..7...24.",
							 ".64.1.59.",
							 ".98...3..",
							 "...8.3.2.",
							 "........6",
							 "...2759.."};
		char[][] board = new char[9][9];
		for(int i=0; i<9; i++)
			for(int j=0; j<9; j++)
				board[i][j] = strBoard[i].charAt(j);
		new SudokuSolver().solveSudoku(board);
		for(int i=0; i<9; i++)
			System.out.println(board[i]);
	}
}
