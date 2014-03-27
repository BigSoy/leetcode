package problems;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Reference : http://www.programcreek.com/2012/12/leetcode-solution-of-iterative-binary-tree-postorder-traversal-in-java/
 * @author ls
 *
 */
public class BinaryTreePostorderTraversal {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root == null)
			return result;
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		TreeNode prev = null;
		
		while(!s.isEmpty()) {
			TreeNode cur = s.peek();
			
			// go down the tree
			if(prev == null || prev.left == cur || prev.right == cur) {
				if(cur.left != null) {
					s.push(cur.left);
				} else if(cur.right != null) {
					s.push(cur.right);
				} else {
					s.pop();
					result.add(cur.val);
				}
			}
			
			// go up the tree from left
			else if(prev == cur.left) {
				if(cur.right != null) {
					s.push(cur.right);
				} else {
					s.pop();
					result.add(cur.val);
				}
			}
			
			// go up the tree from right
			else if(prev == cur.right) {
				s.pop();
				result.add(cur.val);
			}
			
			prev = cur;
		}
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		ArrayList<Integer> result = new BinaryTreePostorderTraversal().postorderTraversal(root);
		for(int i=0; i<result.size(); i++)
			System.out.print(result.get(i) + " ");
	}
}
