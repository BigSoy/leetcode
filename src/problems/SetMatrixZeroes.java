package problems;

public class SetMatrixZeroes {

	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		if(m == 0)
			return;
		int n = matrix[0].length;
		boolean rowZero = false, colZero = false;
		// first column
		for(int i=0; i<m; i++) {
			if(matrix[i][0] == 0) {
				colZero = true;
				break;
			}
		}
		// first row
		for(int j=0; j<n; j++) {
			if(matrix[0][j] == 0) {
				rowZero = true;
				break;
			}
		}
		// mark the rest of the matrix
		for(int i=1; i<m; i++)
			for(int j=1; j<n; j++) {
				if(matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		// set rows
		for(int i=1; i<m; i++) {
			if(matrix[i][0] == 0) {
				for(int j=1; j<n; j++)
					matrix[i][j] = 0;
			}
		}
		// set columns
		for(int j=1; j<n; j++) {
			if(matrix[0][j] == 0) {
				for(int i=1; i<m; i++)
					matrix[i][j] = 0;
			}
		}
		// set first row
		if(rowZero) {
			for(int j=0; j<n; j++)
				matrix[0][j] = 0;
		}
		// set first column
		if(colZero) {
			for(int i=0; i<m; i++)
				matrix[i][0] = 0;
		}
	}
}
