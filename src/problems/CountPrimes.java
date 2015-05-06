package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountPrimes {

	// ∆”ÀÿΩ‚∑®
	public int countPrimes(int n) {
		int num = 0;
		List<Integer> primes = new ArrayList<Integer>();
		for(int i=2; i<n; i++) {
			if(i == 2) {
				primes.add(i);
				num++;
			} else if((i & 1) == 0) {
				continue;
			} else {
				boolean p = true;
				int k = (int)Math.sqrt(i);
				for(int j=0; j<num; j++) {
					if(primes.get(j) > k)
						break;
					if(i % primes.get(j) == 0) {
						p = false;
						break;
					}
				}
				if(p) {
					primes.add(i);
					num++;
				}
			}
		}
		return num;
	}
	
	/*
	 * Sieve of Eratosthenes
	 * http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
	 */
	public int countPrimes1(int n) {
		boolean[] p = new boolean[n];
		Arrays.fill(p, true);
		int k = (int)Math.sqrt(n);
		for(int i=2; i<=k; i++) {
			if(p[i]) {
				int j = i*i;
				while(j < n) {
					p[j] = false;
					j += i;
				}
			}
		}
		int count = 0;
		for(int i=2; i<n; i++)
			if(p[i])
				count++;
		return count;
	}
	
	public static void main(String[] args) {
		int n = 15;
		System.out.println(new CountPrimes().countPrimes1(n));
	}

}
