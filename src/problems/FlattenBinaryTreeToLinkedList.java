package problems;

public class FlattenBinaryTreeToLinkedList {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public void flatten(TreeNode root) {
		if(root == null)
			return;
		flatten(root.left);
		flatten(root.right);
		if(root.left != null) {
			TreeNode i = root.left;
			while(i.right != null) {
				i = i.right;
			}
			i.right = root.right;
			root.right = root.left;
			root.left = null;
		}
	}
}
