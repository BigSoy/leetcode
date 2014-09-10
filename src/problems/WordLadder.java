package problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	
	public int ladderLength(String start, String end, Set<String> dict) {
		Queue<String> queue = new LinkedList<String>();
		Set<String> searched = new HashSet<String>();
		queue.offer(start);
		searched.add(start);
		int length = 1;
		while(!queue.isEmpty()) {
			int count = queue.size();
			while(count > 0) {
				char[] w = queue.poll().toCharArray();
				for(int i=0; i<w.length; i++) {
					char tmp = w[i];
					for(char c='a'; c<='z'; c++) {
						if(tmp == c) continue;
						w[i] = c;
						String s = new String(w);
						if(s.equals(end))
							return length + 1;
						if(dict.contains(s) && !searched.contains(s)) {
							queue.offer(s);
							searched.add(s);
						}
					}
					w[i] = tmp;
				}
				count--;
			}
			length++;
		}
		return 0;
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
		System.out.println(new WordLadder().ladderLength(start, end, dict));
	}
}
