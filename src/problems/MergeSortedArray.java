package problems;

public class MergeSortedArray {

	public void merge(int A[], int m, int B[], int n) {
		int i = m-1;
		int j = n-1;
		int k = m+n-1;
		while (i>=0 && j>=0) {
			if(A[i] <= B[j])
				A[k--] = B[j--];
			else
				A[k--] = A[i--];
		}
		if(i < 0)
			System.arraycopy(B, 0, A, 0, j+1);
	}
}
