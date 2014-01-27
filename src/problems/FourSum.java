package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FourSum {

	public static void main(String[] args) {
		int target = 0;
		int[] num = {1,0,-1,0,-2,2};
		ArrayList<ArrayList<Integer>> results = new FourSum().fourSum(num, target);
		int size = results.size();
		for (int i=0; i<size; i++) {
			ArrayList<Integer> solution = results.get(i);
			for (int j=0; j<solution.size(); j++) {
				System.out.print(solution.get(j) + " ");
			}
			System.out.println();
		}
	}

	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		Set<ArrayList<Integer>> results_set = new HashSet<ArrayList<Integer>>();
		Arrays.sort(num);
		for(int i=0; i<num.length; i++){
			for(int j=i+1; j<num.length-2; j++){
				int l = j+1;
				int r = num.length-1;
				int s = target - num[i] - num[j];
				while(l < r) {
					int pair_sum = num[l] + num[r];
					if(pair_sum == s) {
						ArrayList<Integer> solution = new ArrayList<Integer>(4);
						solution.add(num[i]);
						solution.add(num[j]);
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
		}
		for(Iterator<ArrayList<Integer>> it=results_set.iterator(); it.hasNext(); ){
			results.add(it.next());
		}
		return results;
    }
	
}
