package problems;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {

	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
	
	public void connect(TreeLinkNode root) {
		if(root == null)
			return;
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeLinkNode firstNode = queue.poll();
			TreeLinkNode curNode = firstNode;
			while(curNode != null) {
				TreeLinkNode nextNode = queue.poll();
				curNode.next = nextNode;
				curNode = nextNode;
			}
			curNode = firstNode;
			if(curNode.left != null || curNode.right != null || curNode.next != null) {
				while(curNode != null) {
					if(curNode.left != null)
						queue.offer(curNode.left);
					if(curNode.right != null)
						queue.offer(curNode.right);
					curNode = curNode.next;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		new PopulatingNextRightPointersInEachNodeII().connect(root);
	}
}
