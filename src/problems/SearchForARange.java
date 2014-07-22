package problems;

public class SearchForARange {

	private int[] binarySearch(int[] A, int start, int end, int target) {
		int[] result = new int[2];
		if(start > end) {
			result[0] = -1;
			result[1] = -1;
			return result;
		}
		int mid = (start + end)/2;
		if(A[mid] == target) {
			int[] l_res, r_res;
			l_res = binarySearch(A, start, mid-1, target);
			r_res = binarySearch(A, mid+1, end, target);
			result[0] = l_res[0] == -1 ? mid : l_res[0];
			result[1] = r_res[0] == -1 ? mid : r_res[1];
			return result;
		} else if(A[mid] < target) {
			return binarySearch(A, mid+1, end, target);
		} else {
			return binarySearch(A, start, mid-1, target);
		}
	}
	
	public int[] searchRange(int[] A, int target) {
		return binarySearch(A, 0, A.length-1, target);
	}
	
	public static void main(String[] args) {
		int[] A = {5, 7, 7, 8, 8, 10};
		int target = 8;
		int[] result = new SearchForARange().searchRange(A, target);
		System.out.println(result[0] + " " + result[1]);
	}

}
