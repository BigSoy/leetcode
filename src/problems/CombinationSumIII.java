package problems;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

	private int count;
	private List<List<Integer>> result = new ArrayList<List<Integer>>();

	private void dfs(int k, int n, List<Integer> cur, int start) {
		if(n == 0) {
			if(cur.size() == count)
				result.add(new ArrayList<Integer>(cur));
			return;
		}
		for(int i=start; i<=9; i++) {
			if(i <= n) {
				cur.add(i);
				dfs(k-1, n-i, cur, i+1);
				cur.remove(cur.size()-1);
			} else {
				break;
			}
		}
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		count = k;
		List<Integer> cur = new ArrayList<Integer>();
		dfs(k, n, cur, 1);
		return result;
	}
	
	public static void main(String[] args) {
		int k = 3;
		int n = 9;
		List<List<Integer>> result = new CombinationSumIII().combinationSum3(k, n);
		for(List<Integer> l : result) {
			for(Integer i : l)
				System.out.print(i + " ");
			System.out.println();
		}
	}

}
