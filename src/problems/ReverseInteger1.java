package problems;

public class ReverseInteger1 {

	public static void main(String[] args) {
		int x = -123;
		int y = new ReverseInteger1().reverse(x);
		System.out.println(y);
	}
	
	public int reverse(int x) {
		int y = 0;
		while(x != 0) {
			y = y * 10 + x % 10;
			x /= 10;
		}
		return y;
	}

}
