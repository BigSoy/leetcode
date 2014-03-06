package problems;

import java.util.Arrays;
import java.util.Stack;

/**
 * Reference : http://www.cnblogs.com/lichen782/p/leetcode_maximal_rectangle.html
 * @author ls
 *
 */
public class MaximalRectangle1 {

	public static void main(String[] args) {
		char[][] matrix = {{'0','1'},{'1','1'}};
		int result = new MaximalRectangle1().maximalRectangle(matrix);
		System.out.println(result);
	}
	
	public int maximalRectangle(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
			return 0;
		int maxArea = 0;
		int[] height = new int[matrix[0].length];
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				if(matrix[i][j] == '1')
					height[j] = i==0 ? 1:height[j] + 1;
				else
					height[j] = 0;
			}
			maxArea = Math.max(maxArea,largestRectangleArea(height));
		}
		return maxArea;
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
