package problems;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public String minWindow(String S, String T) {
		if(S.isEmpty() || T.isEmpty())
			return "";
		char[] s = S.toCharArray();
		char[] t = T.toCharArray();
		int i = 0, j = 0;
		Map<Character, Integer> target = new HashMap<Character, Integer>();
		Map<Character, Integer> found = new HashMap<Character, Integer>();
		for(int k=0; k<t.length; k++) {
			if(target.containsKey(t[k]))
				target.put(t[k], target.get(t[k])+1);
			else
				target.put(t[k], 1);
		}
		
		int start = -1, end = -1;
		int minWin = Integer.MAX_VALUE;
		int count = 0;
		while(j < s.length) {
			if(target.containsKey(s[j])) {
				if(!found.containsKey(s[j])) {
					found.put(s[j], 1);
					count++;
				} else if(found.get(s[j]) < target.get(s[j])) {
					found.put(s[j], found.get(s[j])+1);
					count++;
				} else {
					found.put(s[j], found.get(s[j])+1);
				}
			}
			while(count == t.length) {
				if(j-i+1 < minWin) {
					start = i;
					end = j;
					minWin = end - start + 1;
				}
				// remove s[i] from found
				if(target.containsKey(s[i])) {
					if(found.get(s[i]) <= target.get(s[i]))
						count--;
					if(found.get(s[i]) == 1)
						found.remove(s[i]);
					else
						found.put(s[i], found.get(s[i])-1);
				}
				i++;
			}
			j++;
		}
		return start == -1 ? "" : S.substring(start, end+1);
	}
	
	public static void main(String[] args) {
		String S = "ADOBECODEBANC";
		String T = "ABC";
		System.out.println(new MinimumWindowSubstring().minWindow(S, T));
	}
}
