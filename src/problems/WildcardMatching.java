package problems;

/**
 * DP : Time Limit Exceeded
 * @author ls
 * 
 */
public class WildcardMatching {

	public boolean isMatch(String s, String p) {
		int m = s.length();
		int n = p.length();
		boolean[][] dp = new boolean[m+1][n+1];
		dp[0][0] = true;
		for(int j=1; j<=n; j++) {
			if(p.charAt(j-1) == '*')
				dp[0][j] = true;
			else
				break;
		}
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				if(p.charAt(j-1) == '?') {
					dp[i][j] = dp[i-1][j-1];
				} else if(p.charAt(j-1) == '*') {
					for(int k=0; k<=i; k++) {
						if(dp[k][j-1]) {
							dp[i][j] = true;
							break;
						}
					}
				} else {
					dp[i][j] = s.charAt(i-1) == p.charAt(j-1) ? dp[i-1][j-1] : false;
				}
			}
		}
		return dp[m][n];
	}
	
	public static void main(String[] args) {
		String s = "aab";
		String p = "c*a*b";
		System.out.println(new WildcardMatching().isMatch(s, p));
	}
}
