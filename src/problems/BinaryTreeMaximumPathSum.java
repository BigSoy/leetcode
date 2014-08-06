package problems;

public class BinaryTreeMaximumPathSum {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	private int maxSum = Integer.MIN_VALUE;
	
	private int maxSum(TreeNode root) {
		if(root == null)
			return 0;
		int m = root.val;
		int l = maxSum(root.left);
		int r = maxSum(root.right);
		m += l > 0 ? l : 0;
		m += r > 0 ? r : 0;
		maxSum = Math.max(maxSum, m);
		return Math.max(root.val, root.val + Math.max(l, r));
	}
	
	public int maxPathSum(TreeNode root) {
		if(root == null)
			return 0;
		maxSum = Integer.MIN_VALUE;
		maxSum(root);
		return maxSum;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(-2);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		int maxPathSum = new BinaryTreeMaximumPathSum().maxPathSum(root);
		System.out.println(maxPathSum);
	}
}
