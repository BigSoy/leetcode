package problems;

import java.util.Arrays;

public class SearchInRotatedSortedArrayII {

	public static void main(String[] args) {
		int[] A = {7,9,1,4,6};
		int target = 5;
		boolean result = new SearchInRotatedSortedArrayII().search(A, target);
		System.out.println(result);
	}

	public boolean search(int[] A, int target) {
		int begin = 0;
		int end = A.length - 1;
		int mid = (begin + end)/2;
		if (end - begin < 2) {
			if (A[begin] == target) {
				return true;
			} else if(A[end] == target) {
				return true;
			} else {
				return false;
			}
		}
		if (A[mid] == target)
			return true;
		if (A[mid] < A[begin]) {
			if (A[mid+1] <= target && target <= A[end]) {
				int pos = Arrays.binarySearch(A, mid+1, end+1, target);
				return pos < 0 ? false : true;
			} else {
				int[] dest = new int[mid-begin];
				System.arraycopy(A, begin, dest, 0, mid-begin);
				return search(dest, target);
			}
		} else if (A[mid] > A[begin]) {
			if (A[begin] <= target && target <= A[mid-1]) {
				int pos = Arrays.binarySearch(A, begin, mid, target);
				return pos < 0 ? false : true;
			} else {
				int[] dest = new int[end-mid];
				System.arraycopy(A, mid+1, dest, 0, end-mid);
				return search(dest, target);
			}
		} else {
			int[] dest = new int[A.length-1];
			System.arraycopy(A, begin+1, dest, 0, A.length-1);
			return search(dest, target);
		}
    }
	
}
