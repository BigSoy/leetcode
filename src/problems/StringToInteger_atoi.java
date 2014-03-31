package problems;

public class StringToInteger_atoi {

	public static void main(String[] args) {
		String str = " 	123kj";
		int n = new StringToInteger_atoi().atoi(str);
		System.out.println(n);
	}

	public int atoi(String str) {
		if(str == null || str.length() == 0)
			return 0;
		char[] charArr = str.toCharArray();
		int length = charArr.length;
		int i = 0;
		
		// skip all while space characters, not just space character 
		while(i < length && Character.isWhitespace(charArr[i]))
			i++;
		if(i == length)
			return 0;
		boolean minus = charArr[i] == '-' ? true : false;
		if(charArr[i] == '-' || charArr[i] == '+')
			i++;
		
		// type of result is INT, not LONG
		int result = 0;
		while(i < length && Character.isDigit(charArr[i])) {
			int digit = charArr[i] - '0';
			if(result > Integer.MAX_VALUE / 10)
				return minus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			result *= 10;
			if(result > Integer.MAX_VALUE - digit)
				return minus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			result += digit;
			i++;
		}
		result = minus ? -result : result;
		return result;
	}
}
