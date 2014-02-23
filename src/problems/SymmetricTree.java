package problems;

public class SymmetricTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	private boolean isSubTreeSymmetric(TreeNode l, TreeNode r) {
		if(l == null && r == null)
			return true;
		if(l == null || r == null)
			return false;
		if(l.val == r.val) {
			return isSubTreeSymmetric(l.left, r.right) && isSubTreeSymmetric(l.right, r.left);
		} else {
			return false;
		}
	}
	
	public boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		return isSubTreeSymmetric(root.left, root.right);
	}
	
}
