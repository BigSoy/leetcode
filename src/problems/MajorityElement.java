package problems;

public class MajorityElement {

	// Time: O(N), Space: O(1)
	public int majorityElement(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		int seed = nums[0];
		int count = 1;
		for(int i=1; i<nums.length; i++) {
			if(nums[i] == seed)
				count++;
			else {
				if(count > 0)
					count--;
				else {
					seed = nums[i];
					count = 1;
				}
			}
		}
		return seed;
	}
}
