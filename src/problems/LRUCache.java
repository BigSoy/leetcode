package problems;

import java.util.HashMap;

public class LRUCache {
	
	private HashMap<Integer, Node> map = null;
	private Node head = null;
	private int capacity;
	
	public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
    	if(map.containsKey(key)) {
    		Node n = map.get(key);
    		detach(n);
    		attach(n);
    		return n.value;
    	}
        return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)) {
        	Node n = map.get(key);
        	n.value = value;
        	detach(n);
        	attach(n);
        } else {
        	Node n = new Node(key, value);
        	if(map.size() < capacity) {
        		map.put(key, n);
        		attach(n);
        	} else {
        		Node removed = removeLast();
        		map.remove(removed.key);
        		map.put(key, n);
        		attach(n);
        	}
        }
    }
    
    public class Node {
    	private int key;
    	private int value;
    	private Node prev;
    	private Node next;
    	public Node(int key, int value) {
    		this.key = key;
    		this.value = value;
    		prev = null;
    		next = null;
    	}
    }
    
    private void attach(Node n) {
    	if(head == null) {
    		head = n;
    		head.prev = n;
    		head.next = n;
    	} else {
    		head.prev.next = n;
    		n.prev = head.prev;
    		n.next = head;
    		head.prev = n;
    		head = n;
    	}
    }
    
    private void detach(Node n) {
    	// Only one node in the list
    	if(n.next == n && n.prev == n) {
    		head = null;
    	} else {
	    	if(head == n) {
	    		head = head.next;
	    	}
	    	n.prev.next = n.next;
	    	n.next.prev = n.prev;
    	}
    }
    
    private Node removeLast() {
    	Node ret = null;
    	// Only one node in the list
    	if(head.next == head && head.prev == head) {
    		ret = head;
    		head = null;
    	} else {
    		ret = head.prev;
        	ret.prev.next = head;
        	head.prev = ret.prev;
    	}
    	return ret;
    }
    
}
