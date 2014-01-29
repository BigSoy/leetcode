package problems;

/**
 * Reference: http://www.cnblogs.com/daijinqiao/p/3352893.html
 * @author ls
 *
 */
public class SingleNumberII {
	
	public static void main(String[] args) {
		int[] A = {100};
		SingleNumberII instance = new SingleNumberII();
		int r1 = instance.singleNumber(A);
		int r2 = instance.myTry(A);
		System.out.println(r1);
		System.out.println(r2);
	}

	/**
	 * This method is based on the Reference
	 * @param A
	 * @return
	 */
	public int singleNumber(int[] A) {
		int ones = 0, twos = 0, xthrees = 0;
		for(int i=0; i<A.length; i++){
			twos |= (ones & A[i]);	//bits of 2 or 3 "1"
			ones ^= A[i];			//bits of 1 or 3 "1"
			xthrees = ~(ones & twos);
			ones &= xthrees;
			twos &= xthrees;
		}
		return ones;
	}
	
	/**
	 * My solution ( AC, too )
	 * @param A
	 * @return
	 */
	public int myTry(int[] A){
		int ones = 0, twos = 0, xthrees = 0;
		for(int i=0; i<A.length; i++){
			xthrees = ~(twos & A[i]);
			twos = (twos | (ones & A[i])) & xthrees;
			ones = (ones ^ A[i]) & xthrees;
		}
		return ones;
	}
	
}
