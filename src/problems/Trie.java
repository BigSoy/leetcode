package problems;

public class Trie {
	
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
	
	public boolean startsWith(String prefix) {
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

class TrieNode {
	
	protected char val;
	protected TrieNode[] sons;
	protected boolean isEnd;
	
	public TrieNode() {
		sons = new TrieNode[26];
	}
}
