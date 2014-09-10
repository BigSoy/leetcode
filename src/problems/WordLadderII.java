package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Time Limit Exceeded
 * @author ls
 *
 */
public class WordLadderII {

	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> result = new ArrayList<List<String>>();
		Queue<List<String>> queue = new LinkedList<List<String>>();
		Set<String> searched = new HashSet<String>();
		
		List<String> sequence = new ArrayList<String>();
		sequence.add(start);
		queue.offer(sequence);
		searched.add(start);
		
		while(!queue.isEmpty()) {
			int count = queue.size();
			// reserve words used in this level to add to set "searched" after handling with all the nodes in this level
			Set<String> used = new HashSet<String>();
			while(count > 0) {
				sequence = queue.poll();
				char[] word = sequence.get(sequence.size()-1).toCharArray();
				boolean endOccurs = false;
				for(int i=0; i<word.length; i++) {
					char tmp = word[i];
					for(char c='a'; c<='z'; c++) {
						if(tmp == c) continue;
						word[i] = c;
						String s = new String(word);
						if(s.equals(end)) {
							sequence.add(s);
							result.add(sequence);
							used.add(s);
							endOccurs = true;
							break;
						} else if(dict.contains(s) && !searched.contains(s)) {
							// "copy" operation takes much time cost
							List<String> seq = new ArrayList<String>(sequence);
							seq.add(s);
							queue.offer(seq);
							used.add(s);
						}
					}
					word[i] = tmp;
					if(endOccurs) break;
				}
				count--;
			}
			if(used.contains(end))
				return result;
			searched.addAll(used);
		}
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
		List<List<String>> result = new WordLadderII().findLadders(start, end, dict);
		for(List<String> seq : result) {
			for(String s : seq)
				System.out.print(s + " ");
			System.out.println();
		}
	}
}
