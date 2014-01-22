package problems;

/**
 * Method : Manacher¡¯s Algorithm, O(n)
 * @author ls
 *
 */
public class LongestPalindromicSubstring1 {

	public static void main(String[] args) {
		String s = "abaaba";
		String result = new LongestPalindromicSubstring1().longestPalindrome(s);
		System.out.println(result);
	}

	private String preProcess(String s) {
		int len = s.length();
		StringBuffer sb = new StringBuffer();
		sb.append('#');
		for(int i=0; i<len; i++) {
			sb.append(s.charAt(i));
			sb.append('#');
		}
		return sb.toString();
	}
	
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return "";
		String ss = preProcess(s);
		int length = ss.length();
		int[] P = new int[length];
		P[0] = 0;
		P[1] = 1;
		int C = 1, R = 2;
		for (int i=2; i<length; i++) {
			int i_mirror = 2*C - i;
			if (i <= R) {
				P[i] = Math.min(P[i_mirror], R-i);
			} else {
				P[i] = 0;
			}
			while (i+P[i]+1 < length && i-P[i]-1 >= 0 && ss.charAt(i+P[i]+1) == ss.charAt(i-P[i]-1))
				P[i]++;
			if (i+P[i] > R) {
				R = i + P[i];
				C = i;
			}
		}
		
		int maxLen = 1;
		int index = 1;
		for (int i=1; i<length-1; i++) {
			if (P[i] > maxLen) {
				maxLen = P[i];
				index = i;
			}
		}
		int s_begin = (index - maxLen + 1)/2;
		int s_end = (index + maxLen - 1)/2;
		return s.substring(s_begin, s_end+1);
	}
	
}
