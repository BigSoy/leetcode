package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Anagrams {
	
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> ret = new ArrayList<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<strs.length; i++) {
			char[] charArr = strs[i].toCharArray();
			Arrays.sort(charArr);
			String s = new String(charArr);
			if(!map.containsKey(s)) {
				map.put(s, i);
			} else {
				int index = map.get(s);
				if(index >= 0) {
					ret.add(strs[index]);
					map.put(s, -1);
				}
				ret.add(strs[i]);
			}
		}
		return ret;
	}
}
