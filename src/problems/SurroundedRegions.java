package problems;

/**
 * DFS : (Not AC) java.lang.StackOverflowError
 * @author ls
 *
 */
public class SurroundedRegions {

	public void solve(char[][] board) {
		if(board == null || board.length == 0)
			return;
		int m = board.length;
		int n = board[0].length;
		for(int j=0; j<n; j++) {
			if('O' == board[0][j])
				markNotSurrounded(board, 0, j);
			if(m > 1 && 'O' == board[m-1][j])
				markNotSurrounded(board, m-1, j);
		}
		for(int i=1; i<m-1; i++) {
			if('O' == board[i][0])
				markNotSurrounded(board, i, 0);
			if(n > 1 && 'O' == board[i][n-1])
				markNotSurrounded(board, i, n-1);
		}
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if('O' == board[i][j])
					board[i][j] = 'X';
				else if('#' == board[i][j])
					board[i][j] = 'O';
			}
		}
	}
	
	// DFS
	private void markNotSurrounded(char[][] board, int x, int y) {
		if(x < 0 || x >= board.length || y < 0 || y >= board[0].length)
			return;
		if('O' == board[x][y]) {
			board[x][y] = '#';
			markNotSurrounded(board, x-1, y);
			markNotSurrounded(board, x+1, y);
			markNotSurrounded(board, x, y-1);
			markNotSurrounded(board, x, y+1);
		}
	}
	
	public static void main(String[] args) {
		char[][] board = {{'X','X','X'},{'X','O','X'},{'X','X','X'}};
		new SurroundedRegions().solve(board);
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
