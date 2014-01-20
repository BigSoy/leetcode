package problems;

import java.util.HashMap;

/**
 * This method is based on HashMap
 * @author ls
 *
 */
public class TwoSum1 {

	public static void main(String[] args) {
		int[] numbers = {0,4,3,0,3,4,8,8,389,7,8,8};
		int target = 11;
		int[] result = new TwoSum1().twoSum(numbers, target);
		System.out.println(result[0]+" "+result[1]);
	}
	
	public int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>(numbers.length);
		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;
		for(int i = 0; i < numbers.length; i++) {
			int left = target - numbers[i];
			if (indexMap.containsKey(left)) {
				result[0] = indexMap.get(left);
				result[1] = i + 1;
				break;
			} else {
				if (!indexMap.containsKey(numbers[i])) {
					indexMap.put(numbers[i], i+1);
				}
			}
		}
		return result;
	}

}
