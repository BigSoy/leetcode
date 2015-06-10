package problems;

import java.util.TreeSet;

public class ContainsDuplicateIII {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(k < 1 || t < 0)
			return false;
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for(int i=0; i<nums.length; i++) {
			if((ts.floor(nums[i]) != null && ts.floor(nums[i]) + t >= nums[i]) ||
				(ts.ceiling(nums[i]) != null && ts.ceiling(nums[i]) - t <= nums[i])) {
				return true;
			}
			ts.add(nums[i]);
			if(i >= k)
				ts.remove(nums[i-k]);
		}
		return false;
	}
}
