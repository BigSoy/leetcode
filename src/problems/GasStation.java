package problems;

/**
 * Time : O(N)
 * @author ls
 *
 */
public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int n = gas.length;
		int sum = 0;
		int total = 0;
		int start = 0;
		for(int i=0; i<n; i++) {
			sum += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if(sum < 0) {
				start = i+1;
				sum = 0;
			}
		}
		if(total < 0)
			return -1;
		else
			return start;
	}
	
	public static void main(String[] args) {
		int[] gas = {1,2};
		int[] cost = {2,1};
		System.out.println(new GasStation().canCompleteCircuit(gas, cost));
	}

}
