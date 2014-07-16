package problems;

public class ReverseWordsInAString {

	public String reverseWords(String s) {
		String ss = s.trim();
		String result = "";
		int i = ss.length() - 1;
		int r = i;
		while(i >= 0) {
			while(i >= 0 && ss.charAt(i) != ' ')
				i--;
			if(i >= 0)
				result += ss.substring(i+1, r+1) + " ";
			else
				result += ss.substring(i+1, r+1);
			while(i >= 0 && ss.charAt(i) == ' ')
				i--;
			if(i >= 0)
				r = i;
		}
		return result;
	}
	
	public static void main(String[] args) {
		String s = "the sky is blue";
		String result = new ReverseWordsInAString().reverseWords(s);
		System.out.println(result);
	}

}
