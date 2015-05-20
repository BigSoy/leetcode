package problems;

public class HouseRobberII {

	public int rob(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		if(nums.length == 1)
			return nums[0];
		// dp[0] ignores the 1st house, while dp[1] robs the 1st house
		int[][] dp = new int[2][nums.length];
		dp[0] = new int[nums.length];
		dp[1] = new int[nums.length];
		dp[0][0] = 0;
		dp[0][1] = nums[1];
		dp[1][0] = nums[0];
		dp[1][1] = nums[0];
		for(int i=2; i<nums.length; i++) {
			dp[0][i] = Math.max(dp[0][i-1], dp[0][i-2] + nums[i]);
			dp[1][i] = Math.max(dp[1][i-1], dp[1][i-2] + nums[i]);
		}
		return Math.max(dp[0][nums.length-1], dp[1][nums.length-2]);
	}
}
