package problems;

import java.util.ArrayList;

/**
 * O(n) space
 * @author ls
 *
 */
public class RecoverBinarySearchTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	private ArrayList<TreeNode> list = new ArrayList<TreeNode>();
	
	private void inorderTraverse(TreeNode root) {
		if(root == null)
			return;
		inorderTraverse(root.left);
		list.add(root);
		inorderTraverse(root.right);
	}
	
	public void recoverTree(TreeNode root) {
		list.clear();
		inorderTraverse(root);
		TreeNode a = null, b = null;
		for(int i=1; i<list.size(); i++) {
			if(list.get(i).val < list.get(i-1).val) {
				if(a == null) {
					a = list.get(i-1);
					b = list.get(i);
				}
				else {
					b = list.get(i);
					break;
				}
			}
		}
		int tmp = a.val;
		a.val = b.val;
		b.val = tmp;
	}
}
