package problems;

public class MinimumSizeSubarraySum {

	// O(N)
	public int minSubArrayLen(int s, int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		int minLen = nums.length + 1;
		int sum = 0;
		int j = 0;
		for(int i=0; i<nums.length; i++) {
			sum += nums[i];
			while(j < i && sum >= s) {
				minLen = Math.min(minLen, i-j+1);
				sum -= nums[j];
				j++;
			}
			if(j == i && sum >= s)
				return 1;
		}
		return minLen <= nums.length ? minLen : 0;
	}
	
	public static void main(String[] args) {
		int s = 11;
		int[] nums = {1,2,3,4,5};
		System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(s, nums));
	}
}
