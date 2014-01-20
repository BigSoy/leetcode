package problems;

public class ReverseLinkedListII {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static ListNode createList(int [] array) {
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
	
	public static void printList(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] array = {3,5};
		int m = 1, n = 2;
		ListNode head = createList(array);
		printList(head);
		head = new ReverseLinkedListII().reverseBetween(head, m, n);
		printList(head);
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode cur = head, before = null, after = head.next;
		int index = 1;
		ListNode mNode = null, nNode = null;
		if (head != null && head.next != null && m < n) {
			while (index < m) {
				before = cur;
				cur = after;
				after = after.next;
				index++;
			}
			//before points to the node before m
			mNode = cur;
			while (index < n) {
				ListNode tmp = after.next;
				after.next = cur;
				cur= after;
				after = tmp;
				index++;
			}
			//after points to the node after n
			nNode = cur;
			mNode.next = after;
			if (mNode != head) {
				before.next = nNode;
			} else {
				head = nNode;
			}
		}
        return head;
    }
}
