package problems;

public class BitwiseANDofNumbersRange {

	public int rangeBitwiseAnd(int m, int n) {
		int count = 0;
		while(m < n) {
			m >>= 1;
			n >>= 1;
			count++;
		}
        return m << count;
    }
	
	public static void main(String[] args) {
		int m = 5;
		int n = 7;
		System.out.println(new BitwiseANDofNumbersRange().rangeBitwiseAnd(m, n));
	}

}
