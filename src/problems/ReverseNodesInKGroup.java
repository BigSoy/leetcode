package problems;

public class ReverseNodesInKGroup {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || head.next == null)
			return head;
		ListNode newHead = null;
		ListNode p = head;
		ListNode prev = null;
		ListNode segHead = null;
		ListNode segTail = null;
		
		while (p != null) {
			int count = 1;
			ListNode q = p;
			while(count <= k && q != null) {
				count++;
				q = q.next;
			}
			// check if this segment needs to be reversed
			if(count <= k) {
				if(segHead != null)
					segHead.next = p;
				else
					newHead = p;
				break;
			}
			// reverse this segment
			ListNode curSegHead = p;
			int r = 1;
			while(r <= k) {
				ListNode tmp = p.next;
				p.next = prev;
				prev = p;
				p = tmp;
				r++;
			}
			segTail = prev;
			// connect to the previous segment
			if(segHead != null) {
				segHead.next = segTail;
			} else {
				newHead = segTail;
			}
			segHead = curSegHead;
			// segHead is the last node in the new list
			if(p == null)
				segHead.next = null;
		}
		return newHead;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		int k = 2;
		head = new ReverseNodesInKGroup().reverseKGroup(head, k);
		ListNode cur = head;
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
	}
}
