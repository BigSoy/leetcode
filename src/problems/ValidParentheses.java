package problems;

import java.util.Stack;

public class ValidParentheses {

	private boolean isLeft(char c) {
		if(c == '(' || c == '{' || c == '[')
			return true;
		else
			return false;
	}
	
	private boolean match(char l, char r) {
		if( (l=='(' && r==')') || (l=='{' && r=='}') || (l=='[' && r==']') )
			return true;
		else
			return false;
	}
	
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(isLeft(ch)) {
				stack.push(ch);
			} else {
				if(stack.isEmpty() || !match(stack.pop(), ch))
					return false;
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String s = "()[]{}";
		boolean isValid = new ValidParentheses().isValid(s);
		System.out.println(isValid);
	}
}
