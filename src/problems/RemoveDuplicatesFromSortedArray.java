package problems;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int[] A = {1,1,2};
		int result = new RemoveDuplicatesFromSortedArray().removeDuplicates(A);
		System.out.println(result);
	}
	
	public int removeDuplicates(int[] A) {
		if(A == null || A.length == 0)
			return 0;
		int last = 0;
		for(int i=1; i<A.length; i++) {
			if(A[i] == A[last])
				continue;
			else {
				A[last+1] = A[i];
				last++;
			}
		}
		return last+1;
	}

}
