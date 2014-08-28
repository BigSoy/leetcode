package problems;

public class WordSearch {

	private boolean dfs(char[][] board, String word, int pos, int x, int y, boolean[][] used) {
		if(pos == word.length())
			return true;
		if(x < 0 || x >= board.length || y < 0 || y >= board[x].length || used[x][y])
			return false;
		char letter = word.charAt(pos);
		if(letter == board[x][y]) {
			used[x][y] = true;
			if(dfs(board, word, pos+1, x-1, y, used) || dfs(board, word, pos+1, x+1, y, used)
					|| dfs(board, word, pos+1, x, y-1, used) || dfs(board, word, pos+1, x, y+1, used))
				return true;
			used[x][y] = false;
		}
		return false;
	}
	
	public boolean exist(char[][] board, String word) {
		if(board.length == 0)
			return false;
		boolean[][] used = new boolean[board.length][board[0].length];
		boolean exist = false;
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(dfs(board, word, 0, i, j, used)) {
					exist = true;
					break;
				}
			}
			if(exist)
				break;
		}
		return exist;
	}
	
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
		String word = "ABCB";
		System.out.println(new WordSearch().exist(board, word));
	}
}
