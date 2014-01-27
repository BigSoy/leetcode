package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ThreeSum {

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		Set<ArrayList<Integer>> results_set = new HashSet<ArrayList<Integer>>();
		Arrays.sort(num);
		for(int i=0; i<num.length-2; i++){
			int l = i+1;
			int r = num.length-1;
			int s = -num[i];
			while(l < r) {
				int pair_sum = num[l] + num[r];
				if(pair_sum == s) {
					ArrayList<Integer> solution = new ArrayList<Integer>(3);
					solution.add(num[i]);
					solution.add(num[l]);
					solution.add(num[r]);
					results_set.add(solution);
					l++;
					r--;
				} else if(pair_sum < s) {
					l++;
				} else {
					r--;
				}
			}
		}
		for(Iterator<ArrayList<Integer>> it=results_set.iterator(); it.hasNext(); ){
			results.add(it.next());
		}
		return results;
    }
	
}
