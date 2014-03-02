package problems;

import java.util.ArrayList;

public class GrayCode {

	public static void main(String[] args) {
		int n = 2;
		ArrayList<Integer> sequence = new GrayCode().grayCode(n);
		for(int i=0; i<sequence.size(); i++)
			System.out.print(" " + sequence.get(i));
	}
	
	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		int size = 1 << n;
		for(int i=0; i<size; i++)
			ret.add((i >>> 1) ^ i);
		return ret;
	}
}
