package problems;

import java.util.ArrayList;

/**
 * Reference : http://www.cnblogs.com/lichen782/p/leetcode_Generate_Parenthness.html
 * Note : Simple is beautiful
 * @author ls
 *
 */
public class GenerateParentheses {

	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> combinations = new ArrayList<String>();
		String s = "";
		generate(0, 0, n, s, combinations);
		return combinations;
	}
	
	private void generate(int l_num, int r_num, int n, String s, ArrayList<String> result) {
		if(l_num == n) {
			int count = n - r_num;
			while(count-- > 0)
				s += ")";
			result.add(s);
			return;
		}
		generate(l_num+1, r_num, n, s+"(", result);
		if(l_num > r_num)
			generate(l_num, r_num+1, n, s+")", result);
	}
	
	public static void main(String[] args) {
		int n = 3;
		ArrayList<String> combinations = new GenerateParentheses().generateParenthesis(n);
		int size = combinations.size();
		for(int i=0; i<size; i++) {
			System.out.println(combinations.get(i));
		}
	}
}
