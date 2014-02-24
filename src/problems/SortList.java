package problems;

public class SortList {
	
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
	
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode curNode = head;
		int len = 0;
		while(curNode != null) {
			curNode = curNode.next;
			len++;
		}
		int half = len/2;
		ListNode h1 = head, h2 = null;
		curNode = h1;
		int count = 1;
		while(curNode != null) {
			if(count == half) {
				h2 = curNode.next;
				curNode.next = null;
				break;
			}
			curNode = curNode.next;
			count++;
		}
		h1 = sortList(h1);
		h2 = sortList(h2);
		return mergeTwoLists(h1, h2);
	}
	
}
