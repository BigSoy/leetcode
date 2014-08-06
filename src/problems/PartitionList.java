package problems;

public class PartitionList {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode partition(ListNode head, int x) {
		if(head == null || head.next == null)
			return head;
		ListNode newHead = head;
		ListNode k = null, k_prev = null;
		ListNode cur = head, prev = null;
		while(cur != null) {
			if(cur.val >= x)
				break;
			prev = cur;
			cur = cur.next;
		}
		k = cur;
		k_prev = prev;
		while(cur != null) {
			if(cur.val < x) {
				ListNode node = cur;
				prev.next = cur.next;
				cur = cur.next;
				if(k_prev == null)
					newHead = node;
				else
					k_prev.next = node;
				node.next = k;
				k_prev = node;
			} else {
				prev = cur;
				cur = cur.next;
			}
		}
		return newHead;
	}
}
