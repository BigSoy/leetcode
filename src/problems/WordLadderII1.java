package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * BFS + DFS
 * Reference : http://blog.csdn.net/worldwindjp/article/details/19301355
 * @author ls
 *
 */
public class WordLadderII1 {

	private void bfs(String start, String end, Set<String> dict, Map<String,Integer> levels) {
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		levels.put(start, 0);
		while(!queue.isEmpty()) {
			int count = queue.size();
			while(count > 0) {
				String word = queue.poll();
				char[] charArrWord = word.toCharArray();
				for(int i=0; i<charArrWord.length; i++) {
					char tmp = charArrWord[i];
					for(char c='a'; c<='z'; c++) {
						if(tmp == c) continue;
						charArrWord[i] = c;
						String s = new String(charArrWord);
						if(s.equals(end)) {
							levels.put(end, levels.get(word)+1);
						} else if(dict.contains(s) && !levels.containsKey(s)) {
							queue.offer(s);
							levels.put(s, levels.get(word)+1);
						}
					}
					charArrWord[i] = tmp;
				}
				count--;
			}
			if(levels.containsKey(end)) break;
		}
	}
	
	private void dfs(String start, String end, Map<String,Integer> levels, List<String> sequence, List<List<String>> result) {
		if(start.equals(end)) {
			List<String> seq = new ArrayList<String>(sequence);
			seq.add(start);
			Collections.reverse(seq);
			result.add(seq);
			return;
		}
		sequence.add(start);
		char[] charArrWord = start.toCharArray();
		for(int i=0; i<charArrWord.length; i++) {
			char tmp = charArrWord[i];
			for(char c='a'; c<='z'; c++) {
				if(c == tmp) continue;
				charArrWord[i] = c;
				String s = new String(charArrWord);
				if(levels.containsKey(s) && levels.get(s) == levels.get(start)-1) {
					dfs(s, end, levels, sequence, result);
				}
			}
			charArrWord[i] = tmp;
		}
		sequence.remove(sequence.size()-1);
	}
	
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		// record level of every word after BFS
		Map<String,Integer> levels = new HashMap<String,Integer>();
		bfs(start, end, dict, levels);
		List<String> sequence = new ArrayList<String>();
		List<List<String>> result = new ArrayList<List<String>>();
		// search from end to start just because the test cases are so special
		dfs(end, start, levels, sequence, result);
		return result;
	}
	
	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		List<List<String>> result = new WordLadderII1().findLadders(start, end, dict);
		for(List<String> seq : result) {
			for(String s : seq)
				System.out.print(s + " ");
			System.out.println();
		}
	}
}
