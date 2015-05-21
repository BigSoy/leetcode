package problems;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	public boolean isIsomorphic(String s, String t) {
		return hashCheck(s, t) && hashCheck(t, s);
	}

	private boolean hashCheck(String s, String t) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		int len = s.length();
		char[] ss = s.toCharArray();
		char[] tt = t.toCharArray();
		for(int i=0; i<len; i++) {
			if(map.containsKey(ss[i])) {
				if(map.get(ss[i]) != tt[i])
					return false;
			} else {
				map.put(ss[i], tt[i]);
			}
		}
		return true;
	}
}
