package problems;

public class ExcelSheetColumnNumber {

	public int titleToNumber(String s) {
		int n = 0;
		int len = s.length();
		for(int i=0; i<len; i++)
			n = n*26 + (s.charAt(i) - 'A' + 1);
		return n;
	}
	
	public static void main(String[] args) {
		String s = "AB";
		System.out.println(new ExcelSheetColumnNumber().titleToNumber(s));
	}

}
