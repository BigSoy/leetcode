package problems;

/**
 * O(N)
 * Reference : http://www.cnblogs.com/lichen782/p/leetcode_Container_With_Most_Water.html
 * @author ls
 *
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] A = {2,1,2};
		int result = new ContainerWithMostWater().maxArea(A);
		System.out.println(result);
	}

	public int maxArea(int[] height) {
		int maxArea = 0;
		int i = 0;
		int j = height.length - 1;
		while(i < j) {
			int h = Math.min(height[i], height[j]);
			int area = (j - i) * h;
			maxArea = Math.max(area, maxArea);
			if(height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
		}
		return maxArea;
	}
}
