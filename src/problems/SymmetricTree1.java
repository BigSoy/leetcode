package problems;

import java.util.Stack;

public class SymmetricTree1 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode l = root.left;
		TreeNode r = root.right;
		while(l != null || r != null || !stack.isEmpty()) {
			if(l == null && r == null) {
				l = stack.pop();
				r = stack.pop();
			}
			if(l == null || r == null) {
				return false;
			} else {
				if(l.val != r.val)
					return false;
				if(r.left != null && l.right != null) {
					stack.push(r.left);
					stack.push(l.right);
				} else if((r.left==null && l.right!=null) || (r.left!=null && l.right==null)) {
					return false;
				}
				l = l.left;
				r = r.right;
			}
		}
		return true;
	}
	
}
