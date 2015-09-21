package problems;

import java.util.LinkedList;

public class UglyNumberII {

	public int nthUglyNumber(int n) {
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		LinkedList<Integer> l3 = new LinkedList<Integer>();
		LinkedList<Integer> l5 = new LinkedList<Integer>();
		l2.add(1);
		l3.add(1);
		l5.add(1);
		int result = -1;
		for(int i=0; i<n; i++) {
			result = Math.min(Math.min(l2.getFirst(), l3.getFirst()), l5.getFirst());
			if(result == l2.getFirst())
				l2.remove();
			if(result == l3.getFirst())
				l3.remove();
			if(result == l5.getFirst())
				l5.remove();
			
			l2.add(result * 2);
			l3.add(result * 3);
			l5.add(result * 5);
		}
		return result;
	}
}
