package problems;

import java.util.Arrays;

public class MaximumGap {

	public int maximumGap(int[] nums) {
		if(nums == null || nums.length < 2)
			return 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<nums.length; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		double avg_gap = (double)(max - min) / (nums.length - 1);
		// min_max[][i]保存了第i个桶内的最小和最大元素
		int[][] min_max = new int[2][nums.length];
		Arrays.fill(min_max[0], Integer.MAX_VALUE);
		Arrays.fill(min_max[1], Integer.MIN_VALUE);
		for(int i=0; i<nums.length; i++) {
			int bucketId = (int)((nums[i] - min) / avg_gap);
			min_max[0][bucketId] = Math.min(min_max[0][bucketId], nums[i]);
			min_max[1][bucketId] = Math.max(min_max[1][bucketId], nums[i]);
		}
		int max_gap = (int)Math.ceil(avg_gap);
		// 注意考虑某个桶为空的情况
		// 第一个桶一定非空
		int lastMax = min_max[1][0];
		for(int i=1; i<nums.length; i++) {
			if(min_max[0][i] != Integer.MAX_VALUE) {
				max_gap = Math.max(min_max[0][i] - lastMax, max_gap);
				lastMax = min_max[1][i];
			}
		}
		return max_gap;
	}
	
	public static void main(String[] args) {
		int[] nums = {3,6,9,1};
		System.out.println(new MaximumGap().maximumGap(nums));
	}
}
