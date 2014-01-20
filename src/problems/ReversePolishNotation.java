package problems;

import java.util.Stack;

public class ReversePolishNotation {

	public static void main(String[] args) {
		String[] tokens = {"4", "13", "5", "/", "+"};
		int result = new ReversePolishNotation().evalRPN(tokens);
		System.out.println(result);
	}

	private boolean checkOperator(String token) {
		if("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token))
			return true;
		else
			return false;
	}
	
	private int eval(int a, int b, String op) {
		if ("+".equals(op))
			return (a+b);
		else if ("-".equals(op))
			return (a-b);
		else if ("*".equals(op))
			return (a*b);
		else
			return (a/b);
	}
	
	public int evalRPN(String[] tokens) {
		Stack<Integer> s = new Stack<Integer>();
		for(int i = 0; i < tokens.length; i++) {
			if (!checkOperator(tokens[i]))
				s.push(Integer.parseInt(tokens[i]));
			else {
				int b = s.pop();
				int a = s.pop();
				int c = eval(a, b, tokens[i]);
				s.push(c);
			}
		}
        return s.pop();
    }
}
