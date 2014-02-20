package problems;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (root != null) {
			result.add(root.val);
			if(root.right != null)
				s.push(root.right);
			if(root.left != null)
				root = root.left;
			else if(!s.isEmpty())
				root = s.pop();
			else
				root = null;
		}
		return result;
	}
	
}
