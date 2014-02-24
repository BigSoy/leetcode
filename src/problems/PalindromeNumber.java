package problems;

public class PalindromeNumber {

	public static void main(String[] args) {
		int x = 5;
		if(new PalindromeNumber().isPalindrome(x))
			System.out.println("yes");
		else
			System.out.println("no");
	}
	
	private long reverse(int x) {
		long y = 0;
		while(x != 0) {
			y = y * 10 + x % 10;
			x /= 10;
		}
		return y;
	}
	
	public boolean isPalindrome(int x) {
		if(x < 0)
			return false;
		if(x == 0)
			return true;
		if(x > 0 && x == reverse(x))
			return true;
		else
			return false;
	}

}
