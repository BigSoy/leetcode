package problems;

import java.util.ArrayList;

public class PascalTriangle {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> result = new PascalTriangle().generate(5);
		for(int i = 0; i < result.size(); i++) {
			ArrayList<Integer> line = result.get(i);
			for(int j = 0; j < line.size(); j++) {
				System.out.print(line.get(j) + " ");
			}
			System.out.println();
		}
	}
	
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(numRows);
		for(int i = 0; i < numRows; i++) {
			ArrayList<Integer> curline = new ArrayList<Integer>(i+1);
			if(i == 0) {
				curline.add(1);
			} else if (i == 1) {
				curline.add(1);
				curline.add(1);
			} else {
				ArrayList<Integer> upline = result.get(i-1);
				curline.add(1);
				for(int j = 0; j < i-1; j++) {
					curline.add(upline.get(j) + upline.get(j+1));
				}
				curline.add(1);
			}
			result.add(curline);
		}
        return result;
    }
}
