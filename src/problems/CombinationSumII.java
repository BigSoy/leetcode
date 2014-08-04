package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CombinationSumII {

	private List<List<Integer>> dfs(int[] candidates, int len, int target) {
		List<List<Integer>> solution = new ArrayList<List<Integer>>();
		if((len == 0 && target > 0) || (target > 0 && target < candidates[0])) {
			return solution;
		}
		if(target == 0) {
			solution.add(new ArrayList<Integer>());
			return solution;
		}
		if(candidates[len-1] <= target) {
			List<List<Integer>> l1 = dfs(candidates, len-1, target - candidates[len-1]);
			List<List<Integer>> l2 = dfs(candidates, len-1, target);
			for(List<Integer> list : l1) {
				list.add(candidates[len-1]);
			}
			l1.addAll(l2);
			return l1;
		} else {
			return dfs(candidates, len-1, target);
		}
	}
	
	private List<List<Integer>> removeDup(List<List<Integer>> list) {
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		List<List<Integer>> newList = new ArrayList<List<Integer>>();
        for (Iterator<List<Integer>> it = list.iterator(); it.hasNext();) {
            List<Integer> combination = it.next();
            if(set.add(combination))
            	newList.add(combination);
        }
        return newList;
	}
	
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> solution = null;
		if(num == null || num.length == 0) {
			solution = new ArrayList<List<Integer>>();
		} else {
			Arrays.sort(num);
			solution = dfs(num, num.length, target);
			solution = removeDup(solution);
		}
		return solution;
	}
	
	public static void main(String[] args) {
		int[] num = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> solution = new CombinationSumII().combinationSum2(num, target);
		for(List<Integer> list : solution) {
			for(int i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
