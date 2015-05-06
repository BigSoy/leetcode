package problems;

import java.util.Stack;

public class BSTIterator {

	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	private Stack<TreeNode> s = new Stack<TreeNode>();
	
	public BSTIterator(TreeNode root) {
		TreeNode n = root;
		while(n != null) {
			s.push(n);
			n = n.left;
		}
    }
	
	/** @return whether we have a next smallest number */
    public boolean hasNext() {
    	return !s.isEmpty();
    }
    
    /** @return the next smallest number */
    public int next() {
    	TreeNode n = s.pop();
    	int val = n.val;
    	n = n.right;
    	while(n != null) {
    		s.push(n);
    		n = n.left;
    	}
    	return val;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(3);
		root.right = new TreeNode(6);
		BSTIterator i = new BSTIterator(root);
		while(i.hasNext())
			System.out.print(i.next() + " ");
	}

}
