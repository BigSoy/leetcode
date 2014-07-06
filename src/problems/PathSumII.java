package problems;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> allPaths = new ArrayList<List<Integer>>();
		List<Integer> curPath = new ArrayList<Integer>();
		dfs(root, sum, curPath, allPaths);
		return allPaths;
	}
	
	private void dfs(TreeNode root, int sum, List<Integer> curPath, List<List<Integer>> allPaths) {
		if(root == null)
			return;
		if(root.left == null && root.right == null) {
			if(root.val == sum) {
				curPath.add(root.val);
				allPaths.add(new ArrayList<Integer>(curPath));
				curPath.remove(curPath.size()-1);
			}
			return;
		}
		curPath.add(root.val);
		dfs(root.left, sum - root.val, curPath, allPaths);
		dfs(root.right, sum - root.val, curPath, allPaths);
		curPath.remove(curPath.size()-1);
	}
}
