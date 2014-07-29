package problems;

public class ValidateBinarySearchTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	private boolean check(TreeNode root, int lower, int upper) {
		if(root == null)
			return true;
		return root.val > lower && root.val < upper && check(root.left, lower, root.val) && check(root.right, root.val, upper);
	}
	
	public boolean isValidBST(TreeNode root) {
		return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
}
