package problems;

import java.util.HashMap;

public class CopyListWithRandomPointer {

	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	}
	
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null)
			return null;
		RandomListNode newHead = new RandomListNode(head.label);
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		map.put(head, newHead);
		RandomListNode curNode = head, newCurNode = newHead;
		while(curNode.next != null) {
			newCurNode.next = new RandomListNode(curNode.next.label);
			curNode = curNode.next;
			newCurNode = newCurNode.next;
			map.put(curNode, newCurNode);
		}
		curNode = head;
		newCurNode = newHead;
		while(curNode != null) {
			if(curNode.random != null)
				newCurNode.random = map.get(curNode.random);
			curNode = curNode.next;
			newCurNode = newCurNode.next;
		}
		return newHead;
	}
}
