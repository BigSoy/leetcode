package problems;

public class RemoveDuplicatesFromSortedList {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode prevNode = head;
		ListNode curNode = head.next;
		while(curNode != null) {
			if(curNode.val == prevNode.val) {
				prevNode.next = curNode.next;
				curNode = prevNode.next;
			} else {
				prevNode = curNode;
				curNode = curNode.next;
			}
		}
		return head;
	}
	
}
