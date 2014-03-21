package problems;

public class BalancedBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	private int balanceDepth(TreeNode root) {
		if(root == null)
			return 0;
		int leftDepth = balanceDepth(root.left);
		int rightDepth = balanceDepth(root.right);
		int dif = leftDepth - rightDepth;
		if(leftDepth >= 0 && rightDepth >= 0 && dif >= -1 && dif <= 1)
			return Math.max(leftDepth, rightDepth) + 1;
		return -1;
	}
	
	public boolean isBalanced(TreeNode root) {
		if(balanceDepth(root) >= 0)
			return true;
		return false;
	}
}
