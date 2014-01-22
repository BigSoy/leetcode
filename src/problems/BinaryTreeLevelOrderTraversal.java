package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal instance = new BinaryTreeLevelOrderTraversal();
		String[] nodes = { "3", "9", "20", "#", "#", "15", "#", "#", "5" };
		TreeNode root = instance.buildTree(nodes);
		ArrayList<ArrayList<Integer>> result = instance.levelOrder(root);
		for (int i=0; i<result.size(); i++) {
			ArrayList<Integer> level = result.get(i);
			for (int j=0; j<level.size(); j++) {
				System.out.print(level.get(j) + " ");
			}
			System.out.println();
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public TreeNode buildTree(String[] nodes) {
		TreeNode root = null;
		if(nodes.length > 0) {
			root = new TreeNode(Integer.valueOf(nodes[0]));
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);
			for (int i=1; i<nodes.length; i+=2) {
				TreeNode n = queue.poll();
				if (!"#".equals(nodes[i])) {
					n.left = new TreeNode(Integer.valueOf(nodes[i]));
					queue.offer(n.left);
				}
				if (i+1 < nodes.length && !"#".equals(nodes[i+1])) {
					n.right = new TreeNode(Integer.valueOf(nodes[i+1]));
					queue.offer(n.right);
				}
			}
		}
		return root;
	}
	
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				int num = queue.size();
				ArrayList<Integer> level = new ArrayList<Integer>();
				while (num > 0) {
					TreeNode node = queue.poll();
					level.add(node.val);
					if (node.left != null) {
						queue.offer(node.left);
					}
					if (node.right != null) {
						queue.offer(node.right);
					}
					num--;
				}
				ret.add(level);
			}
		}
        return ret;
    }

}
