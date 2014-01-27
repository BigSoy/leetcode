package problems;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] num = {1,1,1,0};
		int target = -100;
		int result = new ThreeSumClosest().threeSumClosest(num, target);
		System.out.println(result);
	}

	public int threeSumClosest(int[] num, int target) {
		int sum = num[0]+num[1]+num[2];
		int closest = sum>target ? sum-target : target-sum;
		if(num.length > 3) {
			Arrays.sort(num);
			for(int i=0; i<num.length-2; i++){
				int l = i+1;
				int r = num.length-1;
				int s = target - num[i];
				while(l < r) {
					int pair_sum = num[l] + num[r];
					if(pair_sum == s) {
						return target;
					} else if(pair_sum < s) {
						if (s-pair_sum < closest) {
							closest = s-pair_sum;
							sum = num[i]+pair_sum;
						}
						l++;
					} else {
						if (pair_sum-s < closest) {
							closest = pair_sum-s;
							sum = num[i]+pair_sum;
						}
						r--;
					}
				}
			}
		}
		return sum;
    }
	
}
