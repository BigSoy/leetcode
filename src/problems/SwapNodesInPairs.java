package problems;

public class SwapNodesInPairs {

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
	
	public static void main(String[] args) {
		int[] array = {};
		SwapNodesInPairs instance = new SwapNodesInPairs();
		ListNode head = instance.createList(array);
		instance.printList(head);
		head = instance.swapPairs(head);
		instance.printList(head);
	}

	public ListNode swapPairs(ListNode head) {
		
		if (head != null && head.next != null) {
			ListNode a = head;
			ListNode b = head.next;
			ListNode before = null, after = b.next;
			
			a.next = b.next;
			b.next = a;
			head = b;
			before = a;
			a = a.next;
			while (a != null && a.next != null) {
				b = a.next;
				after = b.next;
				b.next = a;
				before.next = b;
				a.next = after;
				before = a;
				a = a.next;
			}
		}
        return head;
    }
	
}
