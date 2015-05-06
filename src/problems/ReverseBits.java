package problems;

public class ReverseBits {

	public int reverseBits(int n) {
		int result = 0;
		for(int i=0; i<32; i++) {
			result = (result << 1) | (n & 1);
			n >>= 1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int n = 43261596;
		System.out.println(new ReverseBits().reverseBits(n));
	}

}
