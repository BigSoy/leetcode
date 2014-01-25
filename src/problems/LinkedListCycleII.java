package problems;

/**
 * Reference:	http://www.cnblogs.com/hiddenfox/p/3408931.html
 * @author ls
 *
 */
public class LinkedListCycleII {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode slow = head.next, fast = head.next.next;
		boolean hasCycle = false;
		while (slow != null && fast != null && fast.next != null) {
			if (slow == fast) {
				hasCycle = true;
				slow = head;
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		if (hasCycle) {
			while (fast != slow) {
				fast = fast.next;
				slow = slow.next; 
			}
			return fast;
		}
        return null;
    }
	
}
