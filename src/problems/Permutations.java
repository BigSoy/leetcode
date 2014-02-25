package problems;

import java.util.ArrayList;

public class Permutations {

	private void dfs(int[] num, int n, ArrayList<Integer> p, ArrayList<ArrayList<Integer>> result){
		if(n == num.length) {
			result.add(new ArrayList<Integer>(p));
			return;
		}
		for(int i=0; i<num.length; i++) {
			if(!p.contains(num[i])) {
				p.add(num[i]);
				dfs(num, n+1, p, result);
				p.remove(p.size()-1);
			}
		}
	}
	
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> p = new ArrayList<Integer>();
		dfs(num, 0, p, result);
		return result;
	}
	
	public static void main(String[] args) {
		int[] num = {1,2};
		ArrayList<ArrayList<Integer>> result = new Permutations().permute(num);
		for(int i=0; i<result.size(); i++) {
			ArrayList<Integer> p = result.get(i);
			for(int j=0; j<p.size(); j++)
				System.out.print(p.get(j) + " ");
			System.out.println();
		}
	}

}
