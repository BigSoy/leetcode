package problems;

public class ShortestPalindrome {
	
	public String shortestPalindrome(String s) {
		String r = new StringBuilder(s).reverse().toString();
		String t = s + "#" + r;
		int[] next = new int[t.length()];
		next[0] = -1;
		for(int i=1; i<next.length; i++) {
			int j = next[i-1];
			while(j >= 0 && t.charAt(j+1) != t.charAt(i))
				j = next[j];
			if(j >= 0)
				next[i] = j+1;
			else
				next[i] = t.charAt(i) == t.charAt(0) ? 0 : -1;
		}
		return r.substring(0, r.length() - next[t.length()-1] - 1) + s;
	}

	public static void main(String[] args) {
		String s = "abcd";
		System.out.println(new ShortestPalindrome().shortestPalindrome(s));
	}

}
