package problems;

public class FirstMissingPositive {

	public int firstMissingPositive(int[] A) {
		if(A == null || A.length == 0)
			return 1;
		for(int i=0; i<A.length; i++) {
			while(A[i] > 0 && A[i] <= A.length && A[A[i]-1] != A[i]) {
				int tmp = A[A[i]-1];
				A[A[i]-1] = A[i];
				A[i] = tmp;
			}
		}
		for(int i=0; i<A.length; i++) {
			if(A[i] != i+1)
				return i+1;
		}
		return A.length + 1;
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,0};
		int result = new FirstMissingPositive().firstMissingPositive(A);
		System.out.println(result);
	}

}
