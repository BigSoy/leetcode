package problems;

public class SingleNumber {

	public static void main(String[] args) {
		int[] A = {1,1,2,2,3};
		int result = new SingleNumber().singleNumber(A);
		System.out.println(result);
	}

	public int singleNumber(int[] A) {
		int sum = 0;
		for(int i=0; i<A.length; i++) {
			sum ^= A[i];
		}
		return sum;
	}
	
}
