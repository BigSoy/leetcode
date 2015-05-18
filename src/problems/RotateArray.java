package problems;

public class RotateArray {

	private void reverse(int[] nums, int l, int r) {
		while(l < r) {
			int tmp = nums[l];
			nums[l] = nums[r];
			nums[r] = tmp;
			l++;
			r--;
		}
	}

	// Time: O(N), Space: O(1)
	public void rotate(int[] nums, int k) {
		if(nums == null || nums.length < 2)
			return;
		int n = nums.length;
		while(k < 0)
			k += n;
		if(k == 0)
			return;
		k %= n;
		reverse(nums, 0, n-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, n-1);
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
		new RotateArray().rotate(nums, k);
		for(int i=0; i<nums.length; i++)
			System.out.print(nums[i] + " ");
	}
}
