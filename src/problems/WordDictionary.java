package problems;

public class WordDictionary {

	private class TrieNode {
		protected char val;
		protected TrieNode[] sons;
		protected boolean isEnd;
		public TrieNode() {
			sons = new TrieNode[26];
		}
	}

	private TrieNode root;

	public WordDictionary() {
		root = new TrieNode();
	}
	
	public void addWord(String word) {
		if(word == null || word.isEmpty())
			return;
		TrieNode node = root;
		char[] letters = word.toCharArray();
		for(int i=0, len=letters.length; i<len; i++) {
			int index = letters[i] - 'a';
			if(node.sons[index] == null) {
				node.sons[index] = new TrieNode();
				node.sons[index].val = letters[i];
			}
			node = node.sons[index];
		}
		node.isEnd = true;
	}

	public boolean search(String word) {
		if(word == null || word.isEmpty())
			return true;
		return search(word, root);
	}

	private boolean search(String word, TrieNode root) {
		if(word == null)
			return true;
		if(word.isEmpty())
			return root.isEnd;
		char ch = word.charAt(0);
		if(ch == '.') {
			for(int i=0, len=root.sons.length; i<len; i++) {
				if(root.sons[i] != null)
					if(search(word.substring(1), root.sons[i]))
						return true;
			}
			return false;
		} else {
			int index = ch - 'a';
			if(root.sons[index] == null)
				return false;
			return search(word.substring(1), root.sons[index]);
		}
	}
}
