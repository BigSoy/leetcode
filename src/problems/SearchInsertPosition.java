package problems;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] A = {};
		int target = 2;
		int pos = new SearchInsertPosition().searchInsert(A, target);
		System.out.println(pos);
	}

	public int searchInsert(int[] A, int target) {
		for(int i=0; i<A.length; i++) {
			if(A[i] >= target)
				return i;
		}
		return A.length;
	}
	
}
