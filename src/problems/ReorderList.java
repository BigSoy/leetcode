package problems;

public class ReorderList {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	private ListNode reverseList(ListNode h) {
		ListNode prev = null;
		ListNode cur = h;
		while(cur != null) {
			ListNode tmp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = tmp;
		}
		return prev;
	}
	
	private ListNode mergeList(ListNode h1, ListNode h2) {
		ListNode head = h1;
		h1 = h1.next;
		ListNode cur = head;
		while(h1 != null && h2 != null) {
			cur.next = h2;
			h2 = h2.next;
			cur.next.next = h1;
			h1 = h1.next;
			cur = cur.next.next;
		}
		if(h2 != null)
			cur.next = h2;
		return head;
	}
	
	public void reorderList(ListNode head) {
		if(head == null || head.next == null)
			return;
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode h2 = slow.next;
		slow.next = null;
		h2 = reverseList(h2);
		head = mergeList(head, h2);
	}
	
	public void printList(ListNode head) {
		String s = "";
		ListNode cur = head;
		while(cur != null) {
			s += cur.val + " ";
			cur = cur.next;
		}
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ReorderList instance = new ReorderList();
		instance.reorderList(head);
		instance.printList(head);
	}
}
