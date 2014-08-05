package problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] num) {
		if(num == null || num.length == 0)
			return 0;
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for(int x : num)
			map.put(x, true);
		int maxLen = 0;
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext()) {
			int key = it.next();
			if(map.get(key)) {
				int left = 0, right = 0;
				while(map.containsKey(key-left-1)) {
					map.put(key-left-1, false);
					left++;
				}
				while(map.containsKey(key+right+1)) {
					map.put(key+right+1, false);
					right++;
				}
				map.put(key, false);
				maxLen = Math.max(maxLen, left+right+1);
			}
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		int[] num = {100, 4, 200, 1, 3, 2};
		int length = new LongestConsecutiveSequence().longestConsecutive(num);
		System.out.println(length);
	}
}
