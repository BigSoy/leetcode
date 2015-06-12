package problems;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

	Queue<Integer> queue = new LinkedList<Integer>();
	
	// Push element x onto stack.
    public void push(int x) {
        queue.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int n = queue.size();
        while(n > 1) {
        	queue.offer(queue.poll());
        	n--;
        }
        queue.poll();
    }

    // Get the top element.
    public int top() {
    	int n = queue.size();
        while(n > 1) {
        	queue.offer(queue.poll());
        	n--;
        }
        int top = queue.poll();
        queue.offer(top);
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
    
    public static void main(String[] args) {
    	MyStack s = new MyStack();
    	s.push(1);
    	s.push(2);
    	System.out.println(s.top());
    }
}
