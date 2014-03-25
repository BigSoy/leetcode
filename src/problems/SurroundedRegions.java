package problems;

public class SurroundedRegions {

	public void solve(char[][] board) {
		if(board == null || board.length == 0)
			return;
		int m = board.length;
		int n = board[0].length;
		for(int j=0; j<n; j++) {
			if('o' == board[0][j])
				markNotSurrounded(board, 0, j);
			if(m > 1 && 'o' == board[m-1][j])
				markNotSurrounded(board, m-1, j);
		}
		for(int i=1; i<m-1; i++) {
			if('o' == board[i][0])
				markNotSurrounded(board, i, 0);
			if(n > 1 && 'o' == board[i][n-1])
				markNotSurrounded(board, i, n-1);
		}
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if('o' == board[i][j])
					board[i][j] = 'x';
				else if('#' == board[i][j])
					board[i][j] = 'o';
			}
		}
	}
	
	private void markNotSurrounded(char[][] board, int x, int y) {
		if(x < 0 || x >= board.length || y < 0 || y >= board[0].length)
			return;
		if('o' == board[x][y]) {
			board[x][y] = '#';
			markNotSurrounded(board, x-1, y);
			markNotSurrounded(board, x+1, y);
			markNotSurrounded(board, x, y-1);
			markNotSurrounded(board, x, y+1);
		}
	}
}
