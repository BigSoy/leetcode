package problems;

public class RemoveElement {
	
	public static void main(String[] args) {
		int[] A = {};
		int elem = 3;
		RemoveElement instance = new RemoveElement();
		int newLen = instance.removeElement(A, elem);
		System.out.println(newLen);
		for(int i=0; i<newLen; i++) {
			System.out.print(String.valueOf(A[i]) + " \n".charAt(i==(newLen-1) ? 1:0));
		}
	}
	
	public int removeElement(int[] A, int elem) {
		if(A == null || A.length == 0)
			return 0;
		int count = 0;
		for(int i=0; i<A.length; i++) {
			if(A[i] == elem)
				count++;
		}
		if(count == 0)
			return A.length;
		int tail = 0;
		for(int i=0; i<A.length; i++) {
			if(A[i] == elem)
				continue;
			A[tail++] = A[i];
		}
		return A.length-count;
	}

}
