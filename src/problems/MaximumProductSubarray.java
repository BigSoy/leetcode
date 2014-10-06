package problems;

/**
 * O(N)
 * @author ls
 *
 */
public class MaximumProductSubarray {
	
	public int maxProduct(int[] A) {
		if(A == null || A.length == 0)
			return 0;
		int cur_max = A[0];
		int cur_min = A[0];
		int max = A[0];
		for(int i=1; i<A.length; i++) {
			int a = cur_max * A[i];
			int b = cur_min * A[i];
			int c = A[i];
			cur_max = Math.max(Math.max(a, b), c);
			cur_min = Math.min(Math.min(a, b), c);
			max = cur_max > max ? cur_max : max;
		}
		return max;
	}

	public static void main(String[] args) {
		int[] A = {2,3,-2,4};
		System.out.println(new MaximumProductSubarray().maxProduct(A));
	}
}
