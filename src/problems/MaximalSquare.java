package problems;

public class MaximalSquare {

	public int maximalSquare(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		int maxLen = 0;
		for(int i=0; i<m; i++) {
			dp[i][0] = matrix[i][0] - '0';
			if(dp[i][0] == 1)
				maxLen = 1;
		}
		for(int j=0; j<n; j++) {
			dp[0][j] = matrix[0][j] - '0';
			if(dp[0][j] == 1)
				maxLen = 1;
		}
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				if(matrix[i][j] == '1') {
					dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
					maxLen = Math.max(maxLen, dp[i][j]);
				}
				else {
					dp[i][j] = 0;
				}
			}
		}
		return maxLen*maxLen;
	}
}
