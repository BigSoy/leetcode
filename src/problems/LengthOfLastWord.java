package problems;

public class LengthOfLastWord {

	public static void main(String[] args) {
		String s = "Hello wolrd";
		int len = new LengthOfLastWord().lengthOfLastWord(s);
		System.out.println(len);
	}
	
	public int lengthOfLastWord(String s) {
		if(s == null || s.length() == 0)
			return 0;
		int i = s.length() - 1;
		char[] charArray = s.toCharArray();
		while (i >= 0 && charArray[i] == ' ')
			i--;
		if(i >= 0) {
			int j = i - 1;
			while (j >= 0 && charArray[j] != ' ')
				j--;
			return i-j;
		}
		return 0;
	}

}
