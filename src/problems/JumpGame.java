package problems;

public class JumpGame {

	public static void main(String[] args) {
		int[] A = {3,2,1,0,4};
		if(new JumpGame().canJump(A))
			System.out.println("yes");
		else
			System.out.println("no");
	}
	
	public boolean canJump(int[] A) {
		if(A == null || A.length == 0)
			return true;
		return canJumpToN(A, A.length);
	}
	
	private boolean canJumpToN(int[] A, int n) {
		if(n == 1)
			return true;
		for(int i=n-2; i>=0; i--) {
			if(A[i] >= n-1-i)
				return canJumpToN(A, i+1);
		}
		return false;
	}
}
