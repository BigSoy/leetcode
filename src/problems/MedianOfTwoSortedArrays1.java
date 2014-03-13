package problems;

/**
 * Reference : http://www.cnblogs.com/lichen782/p/leetcode_Median_of_Two_Sorted_Arrays.html
 * O( log(m + n) )
 * @author ls
 *
 */
public class MedianOfTwoSortedArrays1 {

	public static void main(String[] args) {
		int[] A = {1,2,3};
		int[] B = {2,3};
		double median = new MedianOfTwoSortedArrays1().findMedianSortedArrays(A, B);
		System.out.println(median);
	}

	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		int size = m + n;
		if(size % 2 == 1)
			return findKth(A, 0, m, B, 0, n, size/2+1);
		else
			return (double)(findKth(A, 0, m, B, 0, n, size/2) + 
					findKth(A, 0, m, B, 0, n, size/2+1)) / 2;
	}
	
	private int findKth(int[] A, int off_a, int m, int[] B, int off_b, int n, int k) {
		if(m > n)
			return findKth(B, off_b, n, A, off_a, m, k);
		if(m == 0)
			return B[off_b + k - 1];
		if(k == 1)
			return Math.min(A[off_a], B[off_b]);
		int pa = Math.min(k/2, m);
		int pb = k - pa;
		if(A[off_a + pa - 1] < B[off_b + pb - 1])
			return findKth(A, off_a + pa, m - pa, B, off_b, pb, k - pa);
		else if(A[off_a + pa - 1] > B[off_b + pb - 1])
			return findKth(A, off_a, pa, B, off_b + pb, n - pb, k - pb);
		else
			return A[off_a + pa - 1];
	}
}
