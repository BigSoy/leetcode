package problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Find all subsets without using Set<>
 * @author ls
 *
 */
public class SubsetsII1 {

	ArrayList<ArrayList<Integer>> all_subsets = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> cur_subset = new ArrayList<Integer>();
	
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
		Arrays.sort(S);
		boolean[] cur_subset_vector = new boolean[S.length];
		Arrays.fill(cur_subset_vector, false);
		dfs_no_set(S, 0, cur_subset_vector);
		return all_subsets;
	}
	
	private void dfs_no_set(int[] S, int step, boolean[] cur_subset_vector) {
		if(step == S.length) {
			all_subsets.add(new ArrayList<Integer>(cur_subset));
			return;
		}
		dfs_no_set(S, step+1, cur_subset_vector);
		if(step > 0 && S[step] == S[step-1] && !cur_subset_vector[step-1])
			return;
		cur_subset.add(S[step]);
		cur_subset_vector[step] = true;
		dfs_no_set(S, step+1, cur_subset_vector);
		cur_subset.remove(cur_subset.size()-1);
		cur_subset_vector[step] = false;
	}

	public static void main(String[] args) {
		int[] S = {1,2,2};
		ArrayList<ArrayList<Integer>> result = new SubsetsII1().subsetsWithDup(S);
		for(int i=0; i<result.size(); i++){
			ArrayList<Integer> subset = result.get(i);
			for(int j=0; j<subset.size(); j++){
				System.out.print(subset.get(j) + " ");
			}
			System.out.println();
		}
	}
	
}
