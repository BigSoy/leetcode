package problems;

public class EditDistance {

	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int[][] dist = new int[m+1][n+1];
		for(int j=0; j<=n; j++)
			dist[0][j] = j;
		for(int i=0; i<=m; i++)
			dist[i][0] = i;
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				int d1 = word1.charAt(i-1) == word2.charAt(j-1) ? dist[i-1][j-1] : dist[i-1][j-1] + 1;
				int d2 = Math.min(dist[i-1][j], dist[i][j-1]) + 1;
				dist[i][j] = Math.min(d1, d2);
			}
		}
		return dist[m][n];
	}
}
