package problems;

public class RemoveDuplicatesFromSortedArrayII {

	public static void main(String[] args) {
		int[] A = {1,1,2};
		int result = new RemoveDuplicatesFromSortedArrayII().removeDuplicates(A);
		System.out.println(result);
	}
	
	public int removeDuplicates(int[] A) {
		if(A == null || A.length == 0)
			return 0;
		int last = 0;
		boolean twice = false;
		for(int i=1; i<A.length; i++) {
			if(A[i] != A[last]) {
				A[last+1] = A[i];
				last++;
				twice = false;
			} else if(!twice) {
				A[last+1] = A[i];
				last++;
				twice = true;
			}
		}
		return last+1;
	}
}
