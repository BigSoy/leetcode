package problems;

public class RomanToInteger {

	public static void main(String[] args) {
		String s = "MMMCMXCIX";
		int result = new RomanToInteger().romanToInt(s);
		System.out.println(result);
	}
	
	public int romanToInt(String s) {
		int len = s.length();
		if(s == null || len == 0)
			return 0;
		int num = charToInt(s.charAt(0));
		for(int i=1; i<len; i++) {
			int pre = charToInt(s.charAt(i-1));
			int cur = charToInt(s.charAt(i));
			if(cur <= pre)
				num += cur;
			else
				num += cur - 2 * pre;
		}
		return num;
	}
	
	private int charToInt(char c) {
		int num = 0;
		switch (c) {
		case 'M':
			num = 1000;
			break;
		case 'D':
			num = 500;
			break;
		case 'C':
			num = 100;
			break;
		case 'L':
			num = 50;
			break;
		case 'X':
			num = 10;
			break;
		case 'V':
			num = 5;
			break;
		case 'I':
			num = 1;
			break;
		default:
			break;
		}
		return num;
	}

}
