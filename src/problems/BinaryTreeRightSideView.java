package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if(root != null) {
			q.offer(root);
			while(!q.isEmpty()) {
				int size = q.size();
				for(int i=0; i<size; i++) {
					TreeNode n = q.poll();
					if(n.left != null)
						q.offer(n.left);
					if(n.right != null)
						q.offer(n.right);
					if(i == size-1)
						ret.add(n.val);
				}
			}
		}
		return ret;
	}
	
}
