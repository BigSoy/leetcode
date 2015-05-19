package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

	private class TrieNode {
		protected TrieNode[] sons;
		protected boolean isEnd;
		public TrieNode() {
			sons = new TrieNode[26];
		}
	}

	private class Trie {
		private TrieNode root;
		public Trie() {
			root = new TrieNode();
		}
		public void insert(String word) {
			if(word == null || word.isEmpty())
				return;
			TrieNode node = root;
			char[] letters = word.toCharArray();
			for(int i=0, len=letters.length; i<len; i++) {
				int index = letters[i] - 'a';
				if(node.sons[index] == null)
					node.sons[index] = new TrieNode();
				node = node.sons[index];
			}
			node.isEnd = true;
		}
		public boolean isWord(String word) {
			if(word == null || word.isEmpty())
				return true;
			TrieNode node = root;
			char[] letters = word.toCharArray();
			for(int i=0, len=letters.length; i<len; i++) {
				int index = letters[i] - 'a';
				if(node.sons[index] == null)
					return false;
				node = node.sons[index];
			}
			return node.isEnd;
		}
		public boolean isPrefix(String prefix) {
			if(prefix == null || prefix.isEmpty())
				return true;
			TrieNode node = root;
			char[] letters = prefix.toCharArray();
			for(int i=0, len=letters.length; i<len; i++) {
				int index = letters[i] - 'a';
				if(node.sons[index] == null)
					return false;
				node = node.sons[index];
			}
			return true;
		}
	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<String>();
		Set<String> resultSet = new HashSet<String>();
		Trie trie = new Trie();
		for(String w : words)
			trie.insert(w);
		int m = board.length;
		int n = board[0].length;
		boolean[][] used = new boolean[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				dfs(board, i, j, "", trie, resultSet, used);
			}
		}
		for(String s : resultSet)
			result.add(s);
		return result;
	}

	private void dfs(char[][] board, int x, int y, String cur, Trie trie, Set<String> resultSet, boolean[][] used) {
		if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || used[x][y])
			return;
		String s = cur + board[x][y];
		if(trie.isPrefix(s)) {
			if(trie.isWord(s))
				resultSet.add(s);
			used[x][y] = true;
			dfs(board, x-1, y, s, trie, resultSet, used);
			dfs(board, x+1, y, s, trie, resultSet, used);
			dfs(board, x, y-1, s, trie, resultSet, used);
			dfs(board, x, y+1, s, trie, resultSet, used);
			used[x][y] = false;
		}
	}

	public static void main(String[] args) {
		char[][] board = { {'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'} };
		String[] words = { "oath", "pea", "eat", "rain" };
		List<String> result = new WordSearchII().findWords(board, words);
		for(String s : result)
			System.out.println(s);
	}
}
