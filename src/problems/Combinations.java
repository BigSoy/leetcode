package problems;

import java.util.ArrayList;

public class Combinations {

	public static void main(String[] args) {
		int n = 0;
		int k = 0;
		ArrayList<ArrayList<Integer>> result = new Combinations().combine(n, k);
		for(int i=0; i<result.size(); i++) {
			ArrayList<Integer> c = result.get(i);
			for(int j=0; j<k; j++)
				System.out.print(c.get(j) + " ");
			System.out.println();
		}
	}

	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> combine = new ArrayList<Integer>();
		dfs(n, k, 0, combine, result);
		return result;
	}
	
	private void dfs(int n, int k, int step, ArrayList<Integer> combine, ArrayList<ArrayList<Integer>> result) {
		if(step == k) {
			result.add(new ArrayList<Integer>(combine));
			return;
		}
		int begin = (step == 0 ? 1 : 1+combine.get(step-1));
		for(int i=begin; i<=n; i++) {
			combine.add(i);
			dfs(n, k, step+1, combine, result);
			combine.remove(step);
		}
	}
}
