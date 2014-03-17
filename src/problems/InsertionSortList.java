package problems;

public class InsertionSortList {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode inserted = head.next;
		ListNode prevInserted = head;
		while(inserted != null) {
			ListNode cur = head;
			ListNode prev = null;
			while(cur != inserted) {
				if(cur.val > inserted.val) {
					ListNode tmp = inserted;
					inserted = inserted.next;
					prevInserted.next = inserted;
					if(prev != null) {
						prev.next = tmp;
						tmp.next = cur;
					} else{
						tmp.next = cur;
						head = tmp;
					}
					break;
				} else{
					prev = cur;
					cur = cur.next;
				}
			}
			if(cur == inserted) {
				prevInserted = inserted;
				inserted = inserted.next;
			}
		}
		return head;
	}
}
