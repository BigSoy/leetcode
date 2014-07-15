package problems;

public class TrappingRainWater {

	public int trap(int[] A) {
		int[] rightMostHigh = new int[A.length];
		int highest = 0;
		for(int i=A.length-1; i>=0; i--) {
			rightMostHigh[i] = highest;
			if(A[i] > highest)
				highest = A[i];
		}
		int sum = 0;
		highest = 0;
		for(int i=0; i<A.length; i++) {
			int limit = Math.min(highest, rightMostHigh[i]);
			if(limit > A[i])
				sum += limit - A[i];
			if(A[i] > highest)
				highest = A[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new TrappingRainWater().trap(A));
	}

}
