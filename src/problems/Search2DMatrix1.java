package problems;

/**
 * Search from top right corner
 */
public class Search2DMatrix1 {

	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0)
			return false;
		int i = 0;
		int j = matrix[0].length - 1;
		while(i < matrix.length && j >= 0) {
			if(matrix[i][j] < target) {
				if(j == matrix[0].length - 1)
					i++;
				else
					return false;
			} else if(matrix[i][j] > target) {
				j--;
			} else {
				return true;
			}
		}
		return false;
	}
}
