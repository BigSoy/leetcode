package problems;

public class RotateImage {

	public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
        	return;
        int n = matrix.length;
        for(int i=0; i<n-1; i++) {
        	for(int j=0; j<n-1-i; j++) {
        		int tmp = matrix[i][j];
        		matrix[i][j] = matrix[n-1-j][n-1-i];
        		matrix[n-1-j][n-1-i] = tmp;
        	}
        }
        for(int i=0; i<n/2; i++) {
        	for(int j=0; j<n; j++) {
        		int tmp = matrix[i][j];
        		matrix[i][j] = matrix[n-1-i][j];
        		matrix[n-1-i][j] = tmp;
        	}
        }
    }
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		new RotateImage().rotate(matrix);
		int size = matrix.length;
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
