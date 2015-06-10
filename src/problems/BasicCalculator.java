package problems;

import java.util.Stack;

public class BasicCalculator {

	public int calculate(String s) {
		Stack<Object> stack = new Stack<Object>();
		char[] ss = s.toCharArray();
		for(int i=0; i<ss.length; i++) {
			switch(ss[i]) {
			case '+':
				stack.push(ss[i]);
				break;
			case '-':
				stack.push(ss[i]);
				break;
			case '(':
				stack.push(ss[i]);
				break;
			case ')':
				int e = (int)stack.pop();
				stack.pop();
				if(stack.isEmpty()) {
					stack.push(e);
				} else {
					char c = (char)stack.peek();
					if(c == '+') {
						stack.pop();
						int a = (int)stack.pop();
						stack.push(a+e);
					} else if(c == '-') {
						stack.pop();
						int a = (int)stack.pop();
						stack.push(a-e);
					} else if(c == '(') {
						stack.push(e);
					}
				}
				break;
			case ' ':
				break;
			default :
				int j = i;
				while(j < ss.length && ss[j] >= '0' && ss[j] <= '9') j++;
				int d = Integer.parseInt(s.substring(i, j));
				i = j-1;
				if(stack.isEmpty()) {
					stack.push(d);
				} else {
					char c = (char)stack.peek();
					if(c == '+') {
						stack.pop();
						int a = (int)stack.pop();
						stack.push(a+d);
					} else if(c == '-') {
						stack.pop();
						int a = (int)stack.pop();
						stack.push(a-d);
					} else if(c == '(') {
						stack.push(d);
					}
				}
			}
		}
		return (int)stack.pop();
	}
	
	public static void main(String[] args) {
		String s = "(1+(4+5+2)-3)+(6+8)";
		System.out.println(new BasicCalculator().calculate(s));
	}
}
