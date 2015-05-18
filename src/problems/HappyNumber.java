package problems;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<Integer>();
		while(n != 1) {
			set.add(n);
			int sum = 0;
			int k = 0;
			while(n > 0) {
				k = n % 10;
				sum += k*k;
				n /= 10;
			}
			n = sum;
			if(set.contains(n))
				return false;
		}
        return true;
    }

	public static void main(String[] args) {
		int n = 7;
		System.out.println(new HappyNumber().isHappy(n));
	}

}
