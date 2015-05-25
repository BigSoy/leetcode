package problems;

public class RemoveLinkedListElements {

	private class ListNode {
		int val;
 		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode removeElements(ListNode head, int val) {
		while(head != null && head.val == val)
			head = head.next;
		if(head == null)
			return null;		
		ListNode prev = head;
		ListNode cur = head.next;
		while(cur != null) {
			if(cur.val == val)
				prev.next = cur.next;
			else
				prev = cur;
			cur = cur.next;
		}
		return head;
	}
}
