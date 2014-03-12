package problems;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> nextLevelStack = new Stack<TreeNode>();
		if(root != null) {
			stack.push(root);
			boolean tag = true;
			while(!stack.isEmpty()) {
				ArrayList<Integer> levelNodes = new ArrayList<Integer>();
				while(!stack.isEmpty()) {
					TreeNode node = stack.pop();
					levelNodes.add(node.val);
					if(tag) {
						if(node.left != null)
							nextLevelStack.push(node.left);
						if(node.right != null)
							nextLevelStack.push(node.right);
					} else {
						if(node.right != null)
							nextLevelStack.push(node.right);
						if(node.left != null)
							nextLevelStack.push(node.left);
					}
				}
				tag = tag ? false : true;
				Stack<TreeNode> tmp = stack;
				stack = nextLevelStack;
				nextLevelStack = tmp;
				result.add(levelNodes);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		ArrayList<ArrayList<Integer>> result = new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root);
		for(int i=0; i<result.size(); i++) {
			ArrayList<Integer> level = result.get(i);
			for(int j=0; j<level.size(); j++)
				System.out.print(level.get(j) + " ");
			System.out.println();
		}
	}
}
