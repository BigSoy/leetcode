package problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS : (AC)
 * @author ls
 *
 */
public class SurroundedRegions1 {

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
	
	// BFS
	private void markNotSurrounded(char[][] board, int x, int y) {
		Queue<Integer> q = new LinkedList<Integer>();
		visit(board, x, y, q);
		while(!q.isEmpty()) {
			int pos = q.poll();
			int i = pos / board[0].length;
			int j = pos % board[0].length;
			visit(board, i-1, j, q);
			visit(board, i+1, j, q);
			visit(board, i, j-1, q);
			visit(board, i, j+1, q);
		}
	}
	
	private void visit(char[][] board, int x, int y, Queue<Integer> q) {
		int m = board.length;
		int n = board[0].length;
		if(x < 0 || x >= m || y < 0 || y >= n)
			return;
		if('O' == board[x][y]) {
			board[x][y] = '#';
			q.offer(x*n+y);
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
