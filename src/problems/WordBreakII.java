package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * DFS +¡¡memorization
 * @author ls
 * 
 */
public class WordBreakII {

	private boolean[] cannotBreakToEnd = null;
	
	private boolean wordBreak(List<String> solution, List<String> wordSet, String s, Set<String> dict, int index) {
		if(index == s.length()) {
			StringBuffer sb = new StringBuffer();
			for(String ss : wordSet)
				sb.append(ss + " ");
			solution.add(sb.toString().trim());
			return true;
		}
		if(cannotBreakToEnd[index]) {
			return false;
		} else {
			boolean canBreak = false;
			for(int i=index; i<s.length(); i++) {
				String ss = s.substring(index, i+1);
				if(dict.contains(ss)) {
					wordSet.add(ss);
					if(wordBreak(solution, wordSet, s, dict, i+1))
						canBreak = true;
					wordSet.remove(wordSet.size()-1);
				}
			}
			if(!canBreak) {
				cannotBreakToEnd[index] = true;
				return false;
			}
			return true;
		}
	}
	
	public List<String> wordBreak(String s, Set<String> dict) {
		List<String> solution = new ArrayList<String>();
		if(s == null || s.length() == 0 || dict == null || dict.size() == 0)
			return solution;
		List<String> wordSet = new ArrayList<String>();
		cannotBreakToEnd = new boolean[s.length()];
		wordBreak(solution, wordSet, s, dict, 0);
		return solution;
	}
	
	public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		List<String> solution = new WordBreakII().wordBreak(s, dict);
		for(String sentence : solution) {
			System.out.println(sentence);
		}
	}
}
