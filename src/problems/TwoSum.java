package problems;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This method is based on sorting
 * @author ls
 *
 */
public class TwoSum {
	
	public static void main(String[] args) {
		int[] numbers = {0,4,3,0};
		int target = 0;
		int[] result = new TwoSum().twoSum(numbers, target);
		System.out.println(result[0]+" "+result[1]);
	}
	
	private class Node implements Comparable<Node>{
		private int index;
		private int value;
		private Node(int index, int value){
			this.index = index;
			this.value = value;
		}
		@Override
		public int compareTo(Node n){
			int ret = this.value - n.value;
			return ret;
		}
	}
	
	public int[] twoSum(int[] numbers, int target) {
		ArrayList<Node> arr = new ArrayList<Node>();
		for(int i = 0; i < numbers.length; i++){
			arr.add(new Node(i+1, numbers[i]));
		}
		Collections.sort(arr);
		int l = 0;
		int r = numbers.length - 1;
		int index1 = -1;
		int index2 = -1;
		int[] ret = new int[2];
		while(l < r) {
			if (arr.get(l).value + arr.get(r).value == target) {
				index1 = arr.get(l).index;
				index2 = arr.get(r).index;
				break;
			}
			else if (arr.get(l).value + arr.get(r).value < target) {
				l++;
			}
			else {
				r--;
			}
		}
		if(index1 > index2){
			int tmp = index1;
			index1 = index2;
			index2 = tmp;
		}
		ret[0] = index1;
		ret[1] = index2;
        return ret;
    }
}