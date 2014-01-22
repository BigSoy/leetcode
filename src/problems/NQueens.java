package problems;

import java.util.ArrayList;

public class NQueens {

	public static void main(String[] args) {
		int n = 4;
		ArrayList<String[]> result = new NQueens().solveNQueens(n);
		int size = result.size();
		for (int i=0; i<size; i++) {
			System.out.println("solution " + (i+1) + ":");
			for (int j=0; j<n; j++) {
				System.out.println(result.get(i)[j]);
			}
		}
	}

	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> ret = new ArrayList<String[]>();
		
		
        return ret;
    }
}
