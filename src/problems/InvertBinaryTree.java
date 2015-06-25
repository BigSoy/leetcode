package problems;

public class InvertBinaryTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode invertTree(TreeNode root) {
		if(root == null)
			return null;
		TreeNode l = invertTree(root.left);
		TreeNode r = invertTree(root.right);
		root.left = r;
		root.right = l;
		return root;
	}
	
}
