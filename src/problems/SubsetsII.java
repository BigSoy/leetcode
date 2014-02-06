package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SubsetsII {

	ArrayList<ArrayList<Integer>> all_subsets = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> cur_subset = new ArrayList<Integer>();
	Set<ArrayList<Integer>> all_subsets_set = new HashSet<ArrayList<Integer>>();
	
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
		Arrays.sort(S);
		dfs(S, 0);
		for(Iterator<ArrayList<Integer>> it=all_subsets_set.iterator(); it.hasNext(); ) {
			all_subsets.add(it.next());
		}
		return all_subsets;
	}
	
	private void dfs(int[] S, int step) {
		if(step == S.length) {
			all_subsets_set.add(new ArrayList<Integer>(cur_subset));
			return;
		}
		dfs(S, step+1);
		cur_subset.add(S[step]);
		dfs(S, step+1);
		cur_subset.remove(cur_subset.size()-1);
	}
	
	public static void main(String[] args) {
		int[] S = {1,2,2};
		ArrayList<ArrayList<Integer>> result = new SubsetsII().subsetsWithDup(S);
		for(int i=0; i<result.size(); i++){
			ArrayList<Integer> subset = result.get(i);
			for(int j=0; j<subset.size(); j++){
				System.out.print(subset.get(j) + " ");
			}
			System.out.println();
		}
	}
	
}
