package problems;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree1 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int minDepth(TreeNode root) {
		if(root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
		queue.offer(root);
		int depth = 1;
		while(!queue.isEmpty()) {
			boolean leafFound = false;
			while(!queue.isEmpty()) {
				TreeNode node = queue.poll();
				if(node.left == null && node.right == null) {
					leafFound = true;
					break;
				}
				if(node.left != null)
					nextLevel.offer(node.left);
				if(node.right != null)
					nextLevel.offer(node.right);
			}
			if(leafFound)
				break;
			Queue<TreeNode> tmp = queue;
			queue = nextLevel;
			nextLevel = tmp;
			depth ++;
		}
		return depth;
	}
}
