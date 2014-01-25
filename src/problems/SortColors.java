package problems;

public class SortColors {

	public void sortColors(int[] A) {
        int p = 0, q = A.length - 1;
        while (p < A.length && A[p] == 0) {
        	p++;
        };
        while (q >= 0 && A[q] == 2) {
        	q--;
        };
        for (int cur=p; cur<=q; ) {
        	if (A[cur] == 0) {
        		if (cur > p) {
	        		A[cur] = A[p];
	        		A[p] = 0;
        		} else {
        			cur++;
        		}
        		p++;
        	} else if(A[cur] == 2) {
        		A[cur] = A[q];
        		A[q] = 2;
        		q--;
        	} else {
        		cur++;
        	}
        }
    }
	
	public static void main(String[] args) {
		int[] A = {2,0,0};
		new SortColors().sortColors(A);
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
	}

}
