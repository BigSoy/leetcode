package problems;

public class ScrambleString {

	public boolean isScramble(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		if(s1.length() == 0)
			return true;
		int len = s1.length();
		boolean[][][] dp = new boolean[len][len][len+1];
		for(int k = 1; k <= len; k++) {
			for(int i = 0; i <= len-k; i++) {
				for(int j = 0; j <= len-k; j++) {
					if(k == 1)
						dp[i][j][k] = s1.charAt(i) == s2.charAt(j);
					else {
						for(int l = 1; l < k; l++) {
							if((dp[i][j][l] && dp[i+l][j+l][k-l]) || (dp[i][j+k-l][l] && dp[i+l][j][k-l])) {
								dp[i][j][k] = true;
								break;
							}
						}
					}
				}
			}
		}
		return dp[0][0][len];
	}
	
	public static void main(String[] args) {
		String s1 = "great";
		String s2 = "rgtae";
		System.out.println(new ScrambleString().isScramble(s1, s2));
	}
}
