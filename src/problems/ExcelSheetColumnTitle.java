package problems;

public class ExcelSheetColumnTitle {

	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder("");
		while(n > 0) {
			n--;
			sb.append((char)(n % 26 + 'A'));
			n /= 26;
		}
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		int n = 28;
		System.out.println(new ExcelSheetColumnTitle().convertToTitle(n));
	}

}
