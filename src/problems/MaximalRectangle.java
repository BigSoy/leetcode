package problems;

public class MaximalRectangle {
	
	public static void main(String[] args) {
		char[][] matrix = {{'0','1'},{'1','1'}};
		int result = new MaximalRectangle().maximalRectangle(matrix);
		System.out.println(result);
	}
	
	public int maximalRectangle(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
			return 0;
		int maxArea = 0;
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				maxArea = Math.max(maxRect(matrix, i, j), maxArea);
			}
		}
		return maxArea;
	}
	
	private int maxRect(char[][] matrix, int x, int y) {
		int maxArea = 0;
		int minWidth = Integer.MAX_VALUE;
		for(int i=x; i<matrix.length; i++) {
			if(matrix[i][y] == '0')
				break;
			int width = 0;
			while(y+width < matrix[x].length && matrix[i][y+width]=='1' && width<minWidth)
				width++;
			minWidth = Math.min(minWidth, width);
			maxArea = Math.max(maxArea, minWidth * (i - x + 1));
		}
		return maxArea;
	}
}
