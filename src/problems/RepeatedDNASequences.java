package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepeatedDNASequences {
	
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int len = s.length();
		for(int i=0; i<=len-10; i++) {
			String seq = s.substring(i, i+10);
			if(map.containsKey(seq))
				map.put(seq, map.get(seq)+1);
			else
				map.put(seq, 1);
		}
		for(String ss : map.keySet()) {
			if(map.get(ss) > 1)
				result.add(ss);
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		List<String> result = new RepeatedDNASequences().findRepeatedDnaSequences(s);
		for(String ss : result)
			System.out.println(ss);
	}

}
