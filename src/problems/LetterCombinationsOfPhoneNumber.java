package problems;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

	private void dfs(List<String> solution, String comb, String digits, int index) {
		if(index == digits.length()) {
			solution.add(new String(comb));
			return;
		}
		int i = (digits.charAt(index) - '0' - 2) * 3;
		int count = 3;
		switch (i) {
		case 15:
			count++;break;
		case 18:
			i++;break;
		case 21:
			i++;count++;break;
		default:
			break;
		}
		while(count > 0) {
			char ch = (char)('a' + i);
			comb += ch;
			dfs(solution, comb, digits, index+1);
			comb = comb.substring(0, comb.length()-1);
			i++;
			count--;
		}
	}
	
	public List<String> letterCombinations(String digits) {
		List<String> solution = new ArrayList<String>();
		if(digits == null)
			return solution;
		String comb = "";
		dfs(solution, comb, digits, 0);
		return solution;
	}
	
	public static void main(String[] args) {
		String digits = "23";
		List<String> solution = new LetterCombinationsOfPhoneNumber().letterCombinations(digits);
		for(String s : solution) 
			System.out.println(s);
	}
}
