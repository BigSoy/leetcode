package problems;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (root != null) {
			s.push(root);
			if(root.left != null)
				root = root.left;
			else {
				root = s.pop();
				result.add(root.val);
				if(root.right != null)
					root = root.right;
				else {
					while(root.right == null) {
						if(!s.isEmpty()) {
							root = s.pop();
							result.add(root.val);
						} else {
							//special case : root is the last node to travel
							root = null;
							break;
						}
					}
					if(root != null)
						root = root.right;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		new BinaryTreeInorderTraversal().inorderTraversal(root);
	}
	
}
