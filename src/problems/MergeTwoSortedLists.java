package problems;

public class MergeTwoSortedLists {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null)	return l2;
		if(l2 == null)	return l1;
		ListNode head = null;
		ListNode theOther = null;
		ListNode curNode = null;
		if(l1.val <= l2.val) {
			head = l1;
			theOther = l2;
		} else {
			head = l2;
			theOther = l1;
		}
		curNode = head;
		while(theOther != null && curNode.next != null) {
			if(curNode.next.val <= theOther.val) {
				curNode = curNode.next;
			} else {
				ListNode tmpNode = curNode.next;
				curNode.next = theOther;
				curNode = curNode.next;
				theOther = tmpNode;
			}
		}
		if(curNode.next == null)
			curNode.next = theOther;
		return head;
	}
	
}
