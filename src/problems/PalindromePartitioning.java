package problems;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	private boolean[][] makeTable(String s) {
		char[] chArr = s.toCharArray();
		int len = chArr.length;
		boolean[][] dpMat = new boolean[len][len];
		for(int i=0; i<len; i++)
			dpMat[i][i] = true;
		for(int i=1; i<len; i++) {
			//even
			int l = i-1;
			int r = i;
			while(l >= 0 && r < len && chArr[l] == chArr[r])
				dpMat[l--][r++] = true;
			//odd
			l = i - 1;
			r = i + 1;
			while(l >= 0 && r < len && chArr[l] == chArr[r])
				dpMat[l--][r++] = true;
		}
		return dpMat;
	}
	
	private void dfs(List<List<String>> solution, List<String> partition, String s, int pos, boolean[][] table) {
		if(pos == s.length())
			solution.add(new ArrayList<String>(partition));
		for(int i=pos; i<s.length(); i++) {
			if(table[pos][i]) {
				partition.add(s.substring(pos, i+1));
				dfs(solution, partition, s, i+1, table);
				partition.remove(partition.size()-1);
			}
		}
	}
	
	public List<List<String>> partition(String s) {
		List<List<String>> solution = new ArrayList<List<String>>();
		if(s == null || s.length() == 0)
			return solution;
		boolean[][] table = makeTable(s);
		List<String> partition = new ArrayList<String>();
		dfs(solution, partition, s, 0, table);
		return solution;
	}
	
	public static void main(String[] args) {
		String s = "aab";
		List<List<String>> solution = new PalindromePartitioning().partition(s);
		for(List<String> p : solution) {
			for(String ss : p)
				System.out.print(ss + " ");
			System.out.println();
		}
	}
}
