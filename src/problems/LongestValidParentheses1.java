package problems;

import java.util.Arrays;

/**
 * This method is based on DP
 * @author ls
 *
 */
public class LongestValidParentheses1 {

	public static void main(String[] args) {
		int result = new LongestValidParentheses1().longestValidParentheses(")()())");
		System.out.println(result);
	}
	
	public int longestValidParentheses(String s) {
		int N = s.length();
		int[] dp = new int[N];
		Arrays.fill(dp, 0);
		int maxLen = 0;
		for(int i=1; i<N; i++) {
			if (s.charAt(i) == ')') {
				int j = i - dp[i-1] - 1;
				if (j >= 0 && s.charAt(j) == '(') {
					dp[i] = dp[i-1] + 2;
					if (j > 0)
						dp[i] += dp[j-1];
					maxLen = Math.max(maxLen, dp[i]);
				}
			}
		}
		return maxLen;
	}

}
