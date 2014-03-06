package problems;

import java.util.Arrays;
import java.util.Stack;

/**
 * Reference : http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
 * @author ls
 *
 */
public class LargestRectangleInHistogram1 {

	public static void main(String[] args) {
		int[] height = {1};
		int area = new LargestRectangleInHistogram1().largestRectangleArea(height);
		System.out.println(area);
	}
	
	public int largestRectangleArea(int[] height) {
		if(height == null || height.length == 0)
			return 0;
		int[] h = Arrays.copyOf(height, height.length + 1);
		int maxArea = 0;
		int i = 0;
		Stack<Integer> stack = new Stack<Integer>();
		while(i < h.length) {
			if(stack.isEmpty() || h[i] >= h[stack.peek()]) {
				stack.push(i++);
			} else {
				int t = stack.pop();
				int area;
				if(stack.isEmpty())
					area = h[t] * i;
				else
					area = h[t] * (i - stack.peek() - 1);
				maxArea = Math.max(area, maxArea);
			}
		}
		return maxArea;
	}
}
