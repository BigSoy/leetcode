package problems;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	private int[] factorial(int n) {
		int[] factorials = new int[n];
		factorials[0] = 1;
		for(int i=1; i<n; i++)
			factorials[i] = factorials[i-1] * i;
		return factorials;
	}
	
	public String getPermutation(int n, int k) {
		List<Integer> result = new ArrayList<Integer>();
		int[] factorials = factorial(n);
		int r = k;
		for(int i=1; i<=n; i++) {
			int num = (r-1)/factorials[n-i] + 1;
			int count = 0;
			for(int j=1; j<=n; j++) {
				if(!result.contains(j)) {
					count++;
					if(count == num) {
						result.add(j);
						break;
					}
				}
			}
			r -= factorials[n-i]*(num-1);
		}
		String s = "";
		for(int x : result)
			s += x;
		return s;
	}
	
	public static void main(String[] args) {
		int n = 3;
		int k = 1;
		String result = new PermutationSequence().getPermutation(n, k);
		System.out.println(result);
	}
}
