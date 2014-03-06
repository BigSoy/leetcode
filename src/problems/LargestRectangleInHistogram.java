package problems;

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		int[] height = {2,1,5,6,2,3};
		int area = new LargestRectangleInHistogram().largestRectangleArea(height);
		System.out.println(area);
	}

	public int largestRectangleArea(int[] height) {
		if(height == null || height.length == 0)
			return 0;
		int maxArea = height[0];
		for(int i=1; i<height.length; i++) {
			if(i < height.length - 1 && height[i] <= height[i+1])
				continue;
			int area = height[i];
			int minHeight = height[i];
			maxArea = Math.max(maxArea, area);
			for(int j=i-1; j>=0; j--) {
				minHeight = Math.min(minHeight, height[j]);
				area = minHeight * (i - j + 1);
				maxArea = Math.max(maxArea, area);
			}
		}
		return maxArea;
	}
}
