package problems;

public class DistinctSubsequences {

	public int numDistinct(String S, String T) {
		if(S == null || T == null)
			return 0;
		int n = S.length();
		int m = T.length();
		int[][] numDistinct = new int[n+1][m+1];
		for(int i=0; i<=n; i++)
			numDistinct[i][0] = 1;
		for(int j=1; j<=m; j++)
			numDistinct[0][j] = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(S.charAt(i-1) == T.charAt(j-1))
					numDistinct[i][j] = numDistinct[i-1][j-1] + numDistinct[i-1][j];
				else
					numDistinct[i][j] = numDistinct[i-1][j];
			}
		}
		return numDistinct[n][m];
	}
	
	public static void main(String[] args) {
		String S = "rabbbit";
		String T = "rabbit";
		System.out.println(new DistinctSubsequences().numDistinct(S, T));
	}
}
