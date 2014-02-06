package problems;

import java.util.Arrays;

public class SpiralMatrixII {

	public static void main(String[] args) {
		int n = 0;
		int[][] result = new SpiralMatrixII().generateMatrix(n);
		for(int i=0; i<n; i++){
			for(int j=0; j<n;j ++){
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		for(int k=0; k<n; k++){
			Arrays.fill(matrix[k], 0);
		}
		int val = 1;
		int status = 0;
		int i = 0, j = 0;
		int count = n*n;
		while(count > 0) {
			switch (status) {
			case 0:
				matrix[i][j] = val;
				val++;
				if(j < n-1 && matrix[i][j+1] == 0) {
					j++;
				} else {
					i++;
					status = 1;
				}
				break;
			case 1:
				matrix[i][j] = val;
				val++;
				if(i < n-1 && matrix[i+1][j] == 0) {
					i++;
				} else {
					j--;
					status = 2;
				}
				break;
			case 2:
				matrix[i][j] = val;
				val++;
				if(j > 0 && matrix[i][j-1] == 0) {
					j--;
				} else {
					i--;
					status = 3;
				}
				break;
			case 3:
				matrix[i][j] = val;
				val++;
				if(i > 0 && matrix[i-1][j] == 0) {
					i--;
				} else {
					j++;
					status = 0;
				}
				break;
			default:
				break;
			}
			count--;
		}
		return matrix;
	}
	
}
