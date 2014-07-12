package problems;

public class UniquePathsII {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null || obstacleGrid.length == 0|| obstacleGrid[0].length == 0)
			return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		int[][] matrix = new int[m+1][n+1];
		for(int i=0; i<=m; i++)
			matrix[i][n] = 0;
		for(int j=0; j<=n; j++)
			matrix[m][j] = 0;
		
		for(int i=m-1; i>=0; i--) {
			for(int j=n-1; j>=0; j--) {
				if(obstacleGrid[i][j] == 1) {
					if(i == m-1 && j == n-1)
						return 0;
					matrix[i][j] = 0;
				} else {
					if(i == m-1 && j == n-1)
						matrix[i][j] = 1;
					else
						matrix[i][j] = matrix[i+1][j] + matrix[i][j+1];
				}
			}
		}
		return matrix[0][0];
	}
	
}
