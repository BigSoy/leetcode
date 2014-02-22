package problems;

public class ClimbingStairs {

	public static void main(String[] args) {
		int result = new ClimbingStairs().climbStairs(5);
		System.out.println(result);
	}
	
	public int climbStairs(int n) {
		int[] waysNum = new int[n+1];
		waysNum[0] = 1;
		waysNum[1] = 1;
		for(int i=2; i<=n; i++)
			waysNum[i] = waysNum[i-2] + waysNum[i-1];
		return waysNum[n];
	}

}
