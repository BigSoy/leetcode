package problems;

public class ReverseInteger1 {

	public static void main(String[] args) {
		int x = 1534236469;
		int y = new ReverseInteger1().reverse(x);
		System.out.println(y);
	}
	
	public int reverse(int x) {
		long y = 0;
		while(x != 0) {
			y = y * 10 + x % 10;
			x /= 10;
		}
		return (y < Integer.MIN_VALUE || y > Integer.MAX_VALUE) ? 0 : (int)y;
	}

}
