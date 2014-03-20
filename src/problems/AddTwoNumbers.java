package problems;

public class AddTwoNumbers {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode head = new ListNode((l1.val + l2.val) % 10);
		int c = (l1.val + l2.val) / 10;
		ListNode a = l1.next, b = l2.next, s = head;
		while(a != null && b != null) {
			s.next = new ListNode((a.val + b.val + c) % 10);
			c = (a.val + b.val + c) / 10;
			a = a.next;
			b = b.next;
			s = s.next;
		}
		while(a != null) {
			s.next = new ListNode((a.val + c) % 10);
			c = (a.val + c) / 10;
			a = a.next;
			s = s.next;
		}
		while(b != null) {
			s.next = new ListNode((b.val + c) % 10);
			c = (b.val + c) / 10;
			b = b.next;
			s = s.next;
		}
		if(c > 0)
			s.next = new ListNode(c);
		return head;
	}
}
