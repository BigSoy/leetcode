package problems;

public class InterleavingString {

	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1.length() + s2.length() != s3.length())
			return false;
		int l1 = s1.length();
		int l2 = s2.length();
		boolean[][] dp = new boolean[l1+1][l2+1];
		dp[0][0] = true;
		for(int i=1; i<=l1; i++) {
			if(s1.charAt(i-1) == s3.charAt(i-1))
				dp[i][0] = true;
			else
				break;
		}
		for(int j=1; j<=l2; j++) {
			if(s2.charAt(j-1) == s3.charAt(j-1))
				dp[0][j] = true;
			else
				break;
		}
		for(int i=1; i<=l1; i++) {
			for(int j=1; j<=l2; j++) {
				if((dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)))
					dp[i][j] = true;
			}
		}
		return dp[l1][l2];
	}
	
	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbbaccc";
		System.out.println(new InterleavingString().isInterleave(s1, s2, s3));
	}
}
