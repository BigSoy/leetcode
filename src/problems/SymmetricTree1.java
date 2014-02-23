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
		TreeNode l = root.left;
		TreeNode r = root.right;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(r);
		stack.push(l);
		while(!stack.isEmpty()) {
			l = stack.pop();
			r = stack.pop();
			if(l == null && r == null)
				continue;
			
		}
		return true;
	}
	
}
