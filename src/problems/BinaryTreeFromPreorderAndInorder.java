package problems;

public class BinaryTreeFromPreorderAndInorder {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode root = null;
		if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
			return root;
		root = new TreeNode(preorder[0]);
		int i;
		for(i=0; i<inorder.length; i++) {
			if(inorder[i] == root.val)
				break;
		}
		int leftLength = i;
		int rightLength = inorder.length - i - 1;
		if(leftLength > 0) {
			int[] leftPreorder = new int[leftLength];
			int[] leftInorder = new int[leftLength];
			System.arraycopy(preorder, 1, leftPreorder, 0, leftLength);
			System.arraycopy(inorder, 0, leftInorder, 0, leftLength);
			root.left = buildTree(leftPreorder, leftInorder);
		} else {
			root.left = null;
		}
		if(rightLength > 0) {
			int[] rightPreorder = new int[rightLength];
			int[] rightInorder = new int[rightLength];
			System.arraycopy(preorder, leftLength+1, rightPreorder, 0, rightLength);
			System.arraycopy(inorder, leftLength+1, rightInorder, 0, rightLength);
			root.right = buildTree(rightPreorder, rightInorder);
		} else {
			root.right = null;
		}
        return root;
    }
	
}
