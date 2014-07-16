package problems;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {

	public List<Integer> getRow(int rowIndex) {
		ArrayList<Integer> row = new ArrayList<Integer>(rowIndex + 1);
		for(int i=0; i<=rowIndex; i++) {
			if(i == 0)
				row.add(1);
			else {
				int prev = 0;
				int cur;
				for(int col=0; col<i; col++) {
					cur = row.get(col);
					row.set(col, cur + prev);
					prev = cur;
				}
				row.add(1);
			}
		}
		return row;
	}
	
	public static void main(String[] args) {
		int k = 1;
		ArrayList<Integer> row = (ArrayList<Integer>)new PascalTriangleII().getRow(k);
		for(int i=0; i<row.size(); i++)
			System.out.print(row.get(i) + " ");
	}

}
