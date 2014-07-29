package problems;

public class RotateList {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode rotateRight(ListNode head, int n) {
		if(head == null || head.next == null)
			return head;
		ListNode p = head, q = head;
		while(n-- > 0) {
			q = q.next;
			if(q == null)
				q = head;
		}
		if(q == p)
			return head;
		ListNode p_prev = null, q_prev = null;
		while(q != null) {
			p_prev = p;
			q_prev = q;
			p = p.next;
			q = q.next;
		}
		p_prev.next = null;
		q_prev.next = head;
		return p;
	}
}
