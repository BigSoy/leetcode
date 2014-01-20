package problems;

import java.util.Stack;

/**
 * This method is based on STACK
 * @author ls
 *
 */
public class LongestValidParentheses {

	public static void main(String[] args) {
		int result = new LongestValidParentheses().longestValidParentheses("");
		System.out.println(result);
	}
	
	public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int last = -1;
		int maxLen = 0;
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if(stack.isEmpty()) {
					last = i;
				} else {
					stack.pop();
					if(!stack.isEmpty()) {
						maxLen = Math.max(maxLen, i - stack.peek());
					} else {
						maxLen = Math.max(maxLen, i - last);
					}
				}
			}
		}
		return maxLen;
    }
	
}
