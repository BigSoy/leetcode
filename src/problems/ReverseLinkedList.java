package problems;

public class ReverseLinkedList {

	private class ListNode {
		int val;
      	ListNode next;
      	ListNode(int x) { val = x; }
	}

	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode prev = head;
		ListNode cur = head.next;
		prev.next = null;
		while(cur != null) {
			ListNode tmp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = tmp;
		}
		return prev;
	}
}
