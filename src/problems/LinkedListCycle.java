package problems;

public class LinkedListCycle {

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
	
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode p = head.next, p_double = head.next.next;
		while (p != null && p_double != null && p_double.next != null) {
			if (p == p_double)
				return true;
			p = p.next;
			p_double = p_double.next.next;
		}
		return false;
    }
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4};
		LinkedListCycle instance = new LinkedListCycle();
		ListNode head = instance.createList(array);
		if (instance.hasCycle(head)){
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}
	
}
