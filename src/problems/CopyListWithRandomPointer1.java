package problems;

/**
 * Reference : http://www.cnblogs.com/TenosDoIt/p/3387000.html
 * @author latitude
 *
 */
public class CopyListWithRandomPointer1 {

	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	}
	
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null)
			return null;
		RandomListNode curNode = head;
		while(curNode != null) {
			RandomListNode n = new RandomListNode(curNode.label);
			n.next = curNode.next;
			curNode.next = n;
			curNode = n.next;
		}
		curNode = head;
		while(curNode != null) {
			if(curNode.random != null)
				curNode.next.random = curNode.random.next;
			curNode = curNode.next.next;
		}
		RandomListNode newHead = head.next;
		curNode = head;
		RandomListNode newCurNode = newHead;
		while(curNode != null) {
			curNode.next = newCurNode.next;
			curNode = curNode.next;
			if(curNode != null) {
				newCurNode.next = curNode.next;
				newCurNode = newCurNode.next;
			}
		}
		return newHead;
	}
}
