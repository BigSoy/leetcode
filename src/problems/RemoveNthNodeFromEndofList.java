package problems;

public class RemoveNthNodeFromEndofList {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode createList(int [] array) {
		ListNode head = null;
		ListNode cur = null;
		ListNode nxt = null;
		if (array.length > 0) {
			head = new ListNode(array[0]);
			cur = head;
			for(int i = 1; i < array.length; i++) {
				nxt = new ListNode(array[i]);
				cur.next = nxt;
				cur = nxt;
			}
		}
		return head;
	}
	
	public void printList(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println();
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p = head, q = head;
		ListNode qPre = null;
		int count = n - 1;
		if (head == null || head.next == null) {
			return null;
		}
		while (count-- > 0) {
			p = p.next;
		}
		while (p.next != null) {
			p = p.next;
			qPre = q;
			q = q.next;
		}
		if (qPre != null) {
			qPre.next = q.next;
		} else {
			head = q.next;
		}
        return head;
    }
	
	public static void main(String[] args) {
		int n = 1;
		int[] array = {1};
		RemoveNthNodeFromEndofList instance = new RemoveNthNodeFromEndofList();
		ListNode head = instance.createList(array);
		instance.printList(head);
		head = new RemoveNthNodeFromEndofList().removeNthFromEnd(head, n);
		instance.printList(head);
	}

}
