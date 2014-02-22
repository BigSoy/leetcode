package problems;

public class MaxSubarray {

	public static void main(String[] args) {
		int[] A = {-2};
		MaxSubarray instance = new MaxSubarray();
		int result1 = instance.maxSubArray(A);
		int result2 = instance.maxSubArray1(A);
		System.out.println(result1 + " " + result2);
	}
	
	public int maxSubArray(int[] A) {
		if(A == null || A.length == 0)
			return 0;
		int[] sum = new int[A.length];
		sum[0] = A[0];
		for(int i=1; i<A.length; i++) {
			if(sum[i-1] > 0)
				sum[i] = sum[i-1] + A[i];
			else
				sum[i] = A[i];
		}
		int maxSum = sum[0];
		for(int i=1; i<sum.length; i++)
			maxSum = Math.max(maxSum, sum[i]);
		return maxSum;
	}

	/**
	 * Approach : divide and conquer
	 */
	public int maxSubArray1(int[] A) {
		if(A == null || A.length == 0)
			return 0;
		return divide_conquer(A, 0, A.length-1);
	}
	
	private int divide_conquer(int[] A, int l, int r) {
		if(l == r)
			return A[l];
		int mid = (l+r)/2;
		int leftMaxSum = divide_conquer(A, l, mid);
		int rightMaxSum = divide_conquer(A, mid+1, r);
		int maxSum = Math.max(leftMaxSum, rightMaxSum);
		int s1 = A[mid];
		int s2 = A[mid+1];
		int tmpSum;
		tmpSum = A[mid];
		for(int i=mid-1; i>=l; i--) {
			tmpSum += A[i];
			if(tmpSum > s1)
				s1 = tmpSum;
		}
		tmpSum = A[mid+1];
		for(int i=mid+2; i<=r; i++) {
			tmpSum += A[i];
			if(tmpSum > s2)
				s2 = tmpSum;
		}
		maxSum = Math.max(s1+s2, maxSum);
		return maxSum;
	}
	
}
