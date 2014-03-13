package problems;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] A = {1,2,3};
		int[] B = {2,3};
		double median = new MedianOfTwoSortedArrays().findMedianSortedArrays(A, B);
		System.out.println(median);
	}

	private double findMedianSortedArray(int[] arr) {
		int len = arr.length;
		if(len % 2 == 0)
			return (double)(arr[len/2 - 1] + arr[len/2]) / 2;
		else
			return arr[len/2];
	}
	
	public double findMedianSortedArrays(int A[], int B[]) {
		if(A == null || A.length == 0)
			return findMedianSortedArray(B);
		if(B == null || B.length == 0)
			return findMedianSortedArray(A);
		int[] M = new int[A.length + B.length];
		int i = 0, j = 0, k = 0;
		while(i < A.length && j < B.length) {
			if(A[i] <= B[j])
				M[k++] = A[i++];
			else
				M[k++] = B[j++];
		}
		if(i == A.length) {
			while(j < B.length)
				M[k++] = B[j++];
		} else {
			while(i < A.length)
				M[k++] = A[i++];
		}
		return findMedianSortedArray(M);
	}
}
