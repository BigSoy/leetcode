package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElementII {
	
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int t = nums.length/3;
		for(int x : nums) {
			if(map.containsKey(x))
				map.put(x, map.get(x)+1);
			else
				map.put(x, 1);
		}
		for(int k : map.keySet()) {
			if(map.get(k) > t)
				result.add(k);
		}
		return result;
	}

}
