package problems;

public class JumpGameII {

	public static void main(String[] args) {
		int[] A = {2,3,1,1,4};
		int minNum = new JumpGameII().jump(A);
		System.out.println(minNum);
	}
	
	public int jump(int[] A) {
		if(A == null || A.length == 0)
			return 0;
		return jumpToN(A, A.length);
	}
	
	private int jumpToN(int[] A, int n) {
		if(n == 1)
			return 0;
		for(int i=0; i<n-1; i++) {
			if(i + A[i] >= n - 1) {
				return 1 + jumpToN(A, i+1);
			}
		}
		return Integer.MAX_VALUE;
	}
}
