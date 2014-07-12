package problems;

public class UniquePaths {

	public int uniquePaths(int m, int n) {
		if(m == 1 || n == 1)
			return 1;
		int[][] matrix = new int[m+1][n+1];
		for(int i=0; i<=m; i++)
			matrix[i][n] = 0;
		for(int j=0; j<=n; j++)
			matrix[m][j] = 0;
		
		for(int i=m-1; i>=0; i--){
			for(int j=n-1; j>=0; j--) {
				if(i == m-1 && j == n-1)
					matrix[m-1][n-1] = 1;
				else
					matrix[i][j] = matrix[i][j+1] + matrix[i+1][j];
			}
		}
		return matrix[0][0];
	}
	
	public static void main(String[] args) {
		int paths = new UniquePaths().uniquePaths(3, 7);
		System.out.println(paths);
	}

}
