package problems;

public class RemoveDuplicatesFromSortedListII {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode prevNode = head;
		ListNode curNode = head.next;
		ListNode last = null;
		head = null;
		boolean prevDup = false;
		while(curNode != null) {
			if(curNode.val == prevNode.val) {
				prevNode.next = curNode.next;
				curNode = prevNode.next;
				prevDup = true;
			} else {
				if(prevDup) {
					if(last != null) {
						last.next = curNode;
					}
				} else {
					last = prevNode;
					if(head == null)
						head = prevNode;
				}
				prevNode = curNode;
				curNode = curNode.next;
				prevDup = false;
			}
		}
		if(prevDup) {
			if(last != null)
				last.next = null;
		} else if(head == null) {
			head = prevNode;
		}
		return head;
	}
	
	public static void main(String[] args) {
		ListNode h = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(2);
		h.next = n1;
		n1.next = n2;
		h = new RemoveDuplicatesFromSortedListII().deleteDuplicates(h);
	}
}
