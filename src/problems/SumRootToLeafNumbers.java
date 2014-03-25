package problems;

public class SumRootToLeafNumbers {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	private int sum = 0;
	
	private void rootToLeaf(TreeNode root, int upNum) {
		if(root == null)
			return;
		int curNum = upNum * 10 + root.val;
		if(root.left == null && root.right == null) {
			sum += curNum;
			return;
		}
		rootToLeaf(root.left, curNum);
		rootToLeaf(root.right, curNum);
	}
	
	public int sumNumbers(TreeNode root) {
		sum = 0;
		rootToLeaf(root, 0);
		return sum;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(new SumRootToLeafNumbers().sumNumbers(root));
	}
}
