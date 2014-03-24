package problems;

/**
 * O(1) space
 * @author ls
 *
 */
public class RecoverBinarySearchTree1 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	private TreeNode pre = null, a = null, b = null;
	
	private void traverse(TreeNode root) {
		if(root == null)
			return;
		traverse(root.left);
		if(pre != null) {
			if(root.val < pre.val) {
				if(a == null) {
					a = pre;
					b = root;
				} else {
					b = root;
					return;
				}
			}
		}
		pre = root;
		traverse(root.right);
	}
	
	public void recoverTree(TreeNode root) {
		traverse(root);
		if(a != null && b != null) {
			int tmp = a.val;
			a.val = b.val;
			b.val = tmp;
		}
	}
}
