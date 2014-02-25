package problems;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationsII {

	private void dfs(int[] num, int n, ArrayList<Integer> p, ArrayList<ArrayList<Integer>> result, boolean[] used){
		if(n == num.length) {
			result.add(new ArrayList<Integer>(p));
			return;
		}
		for(int i=0; i<num.length; i++) {
			if(i > 0 && num[i] == num[i-1] && !used[i-1])
				continue;
			if(!used[i]) {
				p.add(num[i]);
				used[i] = true;
				dfs(num, n+1, p, result, used);
				p.remove(p.size()-1);
				used[i] = false;
			}
		}
	}
	
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> p = new ArrayList<Integer>();
		boolean[] used = new boolean[num.length];
		Arrays.sort(num);
		dfs(num, 0, p, result, used);
		return result;
	}
	
	public static void main(String[] args) {
		int[] num = {1,1,2};
		ArrayList<ArrayList<Integer>> result = new PermutationsII().permuteUnique(num);
		for(int i=0; i<result.size(); i++) {
			ArrayList<Integer> p = result.get(i);
			for(int j=0; j<p.size(); j++)
				System.out.print(p.get(j) + " ");
			System.out.println();
		}
	}

}
