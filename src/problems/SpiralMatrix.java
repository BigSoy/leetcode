package problems;

import java.util.ArrayList;

public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] matrix = { {1,2,3}, {4,5,6}, {7,8,9} };
		ArrayList<Integer> result = new SpiralMatrix().spiralOrder(matrix);
		for(int i = 0; i < result.size(); i++)
			System.out.print(result.get(i) + " ");
	}
	
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int m = matrix.length;
		if(m == 0) {
			return result;
		}
		int n = matrix[0].length;
		int T = m * n;
		boolean[][] tag = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				tag[i][j] = false;
			}
		}
		int ii = 0;
		int jj = 0;
		int status = 0;
		while(T > 0) {
			result.add(matrix[ii][jj]);
			tag[ii][jj] = true;
			switch (status) {
			case 0:
				if(jj+1 == n || tag[ii][jj+1]) {
					status = 1;
					ii++;
				} else {
					jj++;
				}
				break;
			case 1:
				if(ii+1 == m || tag[ii+1][jj]) {
					status = 2;
					jj--;
				} else {
					ii++;
				}
				break;
			case 2:
				if(jj-1 < 0 || tag[ii][jj-1]) {
					status = 3;
					ii--;
				} else {
					jj--;
				}
				break;
			case 3:
				if(ii-1 < 0 || tag[ii-1][jj]) {
					status = 0;
					jj++;
				} else {
					ii--;
				}
				break;
			default:
				System.out.println("status error");
				break;
			}
			T--;
		}
        return result;
    }

}
