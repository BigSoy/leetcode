package problems;

public class ConvertSortedListToBinarySearchTree {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public TreeNode sortedListToBST(ListNode head) {
		if(head == null)
			return null;
		ListNode curNode = head, prevNode = null;
		int n = 0;
		while(curNode != null) {
			n++;
			curNode = curNode.next;
		}
		int mid = n/2;
		curNode = head;
		while(mid > 0) {
			prevNode = curNode;
			curNode = curNode.next;
			mid--;
		}
		TreeNode root = new TreeNode(curNode.val);
		if(prevNode != null) {
			prevNode.next = null;
			root.left = sortedListToBST(head);
		}
		root.right = sortedListToBST(curNode.next);
		return root;
	}
}
