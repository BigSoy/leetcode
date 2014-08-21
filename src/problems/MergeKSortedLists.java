package problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode mergeKLists(List<ListNode> lists) {
		// int k = lists.size();
		// LeetCode Runtime Error when turn "10" to "k"
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(10, new Comparator<ListNode>(){
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if(o1.val < o2.val)
					return -1;
				else if(o1.val > o2.val)
					return 1;
				else
					return 0;
			}
		});
		ListNode result = null;
		ListNode cur = null;
		for(ListNode n : lists) {
			if(n != null)
				heap.offer(n);
		}
		while(!heap.isEmpty()) {
			ListNode n = heap.poll();
			if(result == null) {
				result = n;
				cur = n;
			} else {
				cur.next = n;
				cur = cur.next;
			}
			if(n.next != null)
				heap.offer(n.next);
		}
		return result;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(4);
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(l1);
		lists.add(l2);
		ListNode result = new MergeKSortedLists().mergeKLists(lists);
		ListNode cur = result;
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
	}
}
