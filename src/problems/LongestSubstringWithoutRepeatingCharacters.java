package problems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.isEmpty())
			return 0;
		char[] str = s.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int maxLen = 1;
		int i = 0;
		for(int j=0; j<str.length; j++) {
			Integer pos = map.get(str[j]);
			if(pos != null && pos >= i) {
				maxLen = Math.max(j-i, maxLen);
				i = pos + 1;
			}
			map.put(str[j], j);
		}
		maxLen = Math.max(str.length-i, maxLen);
		return maxLen;
	}
	
	public static void main(String[] args) {
		String s = "qopubjguxhxdipfzwswybgfylqvjzhar";
		int len = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
		System.out.println(len);
	}
}
