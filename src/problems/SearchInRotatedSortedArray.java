package problems;

import java.util.Arrays;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] A = {7,9,1,4,6};
		int target = 5;
		int result = new SearchInRotatedSortedArray().search(A, target);
		System.out.println(result);
	}

	public int search(int[] A, int target) {
		int begin = 0;
		int end = A.length - 1;
		int mid = (begin + end)/2;
		if (end - begin < 2) {
			if (A[begin] == target) {
				return begin;
			} else if(A[end] == target) {
				return end;
			} else {
				return -1;
			}
		}
		if (A[mid] == target)
			return mid;
		if (A[mid] < A[begin]) {
			if (A[mid+1] <= target && target <= A[end]) {
				int pos = Arrays.binarySearch(A, mid+1, end+1, target);
				return pos < 0 ? -1 : pos;
			} else {
				int[] dest = new int[mid-begin];
				System.arraycopy(A, begin, dest, 0, mid-begin);
				int pos = search(dest, target);
				return pos == -1 ? -1 : pos+begin;
			}
		} else if (A[mid] > A[begin]) {
			if (A[begin] <= target && target <= A[mid-1]) {
				int pos = Arrays.binarySearch(A, begin, mid, target);
				return pos < 0 ? -1 : pos;
			} else {
				int[] dest = new int[end-mid];
				System.arraycopy(A, mid+1, dest, 0, end-mid);
				int pos = search(dest, target);
				return pos == -1 ? -1 : pos+mid+1;
			}
		}
        return -1;
    }
}
