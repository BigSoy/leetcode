package problems;

public class PathSum {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null)
			return false;
		if(root.left == null && root.right == null)
			return root.val == sum ? true : false;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}
