package problems;

import java.util.ArrayList;

public class UniqueBinarySearchTreesII {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; left = null; right = null; }
	}
	
	private ArrayList<TreeNode> generateSubTrees(int begin, int end) {
		if(begin > end)
			return null;
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		for(int i=begin; i<=end; i++) {
			ArrayList<TreeNode> leftSubTrees = generateSubTrees(begin, i-1);
			ArrayList<TreeNode> rightSubTrees = generateSubTrees(i+1, end);
			if(leftSubTrees != null && rightSubTrees != null) {
				for(int l=0; l<leftSubTrees.size(); l++) {
					for(int r=0; r<rightSubTrees.size(); r++) {
						TreeNode root = new TreeNode(i);
						root.left = leftSubTrees.get(l);
						root.right = rightSubTrees.get(r);
						result.add(root);
					}
				}
			} else if(leftSubTrees != null) {
				for(int l=0; l<leftSubTrees.size(); l++) {
					TreeNode root = new TreeNode(i);
					root.left = leftSubTrees.get(l);
					result.add(root);
				}
			} else if(rightSubTrees != null) {
				for(int r=0; r<rightSubTrees.size(); r++) {
					TreeNode root = new TreeNode(i);
					root.right = rightSubTrees.get(r);
					result.add(root);
				}
			} else {
				TreeNode root = new TreeNode(i);
				result.add(root);
			}
		}
		return result;
	}
	
	public ArrayList<TreeNode> generateTrees(int n) {
		if(n == 0) {
			ArrayList<TreeNode> result = new ArrayList<TreeNode>();
			result.add(null);
			return result;
		}
		return generateSubTrees(1, n);
	}
	
	public static void main(String[] args) {
		int n = 3;
		ArrayList<TreeNode> result = new UniqueBinarySearchTreesII().generateTrees(n);
		System.out.println(result.size());
	}
}
