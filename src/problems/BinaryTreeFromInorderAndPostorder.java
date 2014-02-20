package problems;

public class BinaryTreeFromInorderAndPostorder {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		TreeNode root = null;
		if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0)
			return root;
		root = new TreeNode(postorder[postorder.length-1]);
		int i;
		for(i=0; i<inorder.length; i++) {
			if(inorder[i] == root.val)
				break;
		}
		int leftLength = i;
		int rightLength = inorder.length - i - 1;
		if(leftLength > 0) {
			int[] leftInorder = new int[leftLength];
			int[] leftPostorder = new int[leftLength];
			System.arraycopy(inorder, 0, leftInorder, 0, leftLength);
			System.arraycopy(postorder, 0, leftPostorder, 0, leftLength);
			root.left = buildTree(leftInorder, leftPostorder);
		} else {
			root.left = null;
		}
		if(rightLength > 0) {
			int[] rightInorder = new int[rightLength];
			int[] rightPostorder = new int[rightLength];
			System.arraycopy(inorder, leftLength+1, rightInorder, 0, rightLength);
			System.arraycopy(postorder, leftLength, rightPostorder, 0, rightLength);
			root.right = buildTree(rightInorder, rightPostorder);
		} else {
			root.right = null;
		}
		return root;
	}
	
}
