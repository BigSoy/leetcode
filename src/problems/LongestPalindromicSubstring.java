package problems;

/**
 * This method is based on DP, O(n^2)
 * @author ls
 *
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String s = "abaaba";
		String result = new LongestPalindromicSubstring().longestPalindrome(s);
		System.out.println(result);
	}

	public String longestPalindrome(String s) {
		int len = s.length();
		if (len == 0)
			return "";
		boolean[][] palindromic = new boolean[len][len];
		int maxLen = 1;
		int begin = 0, end = 0;
		for (int i=0; i<len; i++) {
			for (int j=0; j<len; j++) {
				if (i>=j) {
					palindromic[i][j] = true;
				} else {
					palindromic[i][j] = false;
				}
			}
		}
		for (int l=2; l<=len; l++) {
			for (int i=0; i<=len-l; i++) {
				int j = i+l-1;
				if(s.charAt(i) == s.charAt(j) && palindromic[i+1][j-1]) {
					palindromic[i][j] = true;
					if (l > maxLen) {
						maxLen = l;
						begin = i;
						end = j;
					}
				}
			}
		}
        return s.substring(begin, end+1);
    }
	
}
