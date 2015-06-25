package problems;

import java.util.Stack;

public class BasicCalculatorII {

	public int calculate(String s) {
		char[] chArr = s.toCharArray();
		Stack<Object> stack = new Stack<Object>();
		Stack<Object> rStack = new Stack<Object>();
		for(int i=0; i<chArr.length; i++) {
			if(chArr[i] >= '0' && chArr[i] <= '9') {
				int j = i++;
				while(i < chArr.length && chArr[i] >= '0' && chArr[i] <= '9')
					i++;
				stack.push(Long.parseLong(s.substring(j, i)));
				i--;
			} else if(chArr[i] == '+' || chArr[i] == '-') {
				stack.push(chArr[i]);
			} else if(chArr[i] == '*' || chArr[i] == '/') {
				long x = (long)stack.pop();
				int index = i++;
				while(i < chArr.length && chArr[i] == ' ')
					i++;
				int j = i;
				while(i < chArr.length && chArr[i] >= '0' && chArr[i] <= '9')
					i++;
				long y = Long.parseLong(s.substring(j, i));
				i--;
				if(chArr[index] == '*') {
					stack.push(x * y);
				} else {
					stack.push(x / y);
				}
			}
		}
		while(!stack.isEmpty())
			rStack.push(stack.pop());
		stack = rStack;
		long result = (long)stack.pop();
		while(!stack.isEmpty()) {
			char op = (char)stack.pop();
			long x = (long)stack.pop();
			switch(op) {
			case '+':
				result += x;
				break;
			case '-':
				result = result - x;
				break;
			}
		}
		return (int)result;
	}
	
	public static void main(String[] args) {
		//String s = " 3+5 / 2 ";
		String s = "1-1+1";
		System.out.println(new BasicCalculatorII().calculate(s));
	}

}
