package problems;

public class ConvertSortedArrayToBinarySearchTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode sortedArrayToBST(int[] num) {
		if(num == null || num.length == 0)
			return null;
		int mid = num.length/2;
		TreeNode root = new TreeNode(num[mid]);
		if(mid > 0) {
			int[] leftArr = new int[mid];
			System.arraycopy(num, 0, leftArr, 0, mid);
			root.left = sortedArrayToBST(leftArr);
		}
		if(mid + 1 < num.length) {
			int[] rightArr = new int[num.length - mid - 1];
			System.arraycopy(num, mid+1, rightArr, 0, num.length - mid - 1);
			root.right = sortedArrayToBST(rightArr);
		}
		return root;
	}
	
	public static void main(String[] args) {
		int[] num = {1,2,3,4,5};
		new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(num);
	}
}
