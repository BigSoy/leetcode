package problems;

public class CountCompleteTreeNodes {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int countNodes(TreeNode root) {
		if(root == null)
			return 0;
		int l_num = 0;
		int r_num = 0;
		TreeNode node = root.left;
		while(node != null) {
			l_num++;
			node = node.left;
		}
		node = root.right;
		while(node != null) {
			r_num++;
			node = node.right;
		}
		if(l_num == r_num)
			return (int)Math.pow(2, l_num+1) - 1;
		return countNodes(root.left) + countNodes(root.right) + 1;
	}
}
