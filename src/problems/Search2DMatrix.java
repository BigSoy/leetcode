package problems;

import java.util.Arrays;

/**
 * Binary search
 */
public class Search2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0)
			return false;
		int n = matrix[0].length;
		
		int l = 0;
		int r = matrix.length - 1;
		while(l <= r) {
			int mid = (l+r)/2;
			if(target < matrix[mid][0]) {
				r = mid - 1;
				continue;
			} else if(target > matrix[mid][n-1]) {
				l = mid + 1;
				continue;
			} else {
				return Arrays.binarySearch(matrix[mid], target) > -1 ? true : false;
			}
		}
		return false;
	}
}
