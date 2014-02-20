package problems;

public class UniqueBinarySearchTrees {
	
	public static void main(String[] args) {
		int num = 3;
		int result = new UniqueBinarySearchTrees().numTrees(num);
		System.out.println(result);
	}
	
	public int numTrees(int n) {
		if(n == 0)
			return 1;
		int sum = 0;
		for(int i=1; i<=n; i++) {
			sum += numTrees(i-1) * numTrees(n-i);
		}
		return sum;
	}
	
}
