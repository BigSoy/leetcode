package problems;

public class ValidNumber {

	public boolean isNumber(String s) {
		if(s == null || s.isEmpty())
			return false;
		char[] str = s.trim().toCharArray();
		int i = 0;
		int len = str.length;
		boolean hasE = false;
		boolean hasDot = false;
		boolean hasDigit = false;
		boolean hasSign = false;
		boolean eDigit = false;
		boolean dotDigit = false;
		while(i < len) {
			if(Character.isSpaceChar(str[i]))
				return false;
			if(Character.isDigit(str[i])) {
				if(hasE)
					eDigit = true;
				if(hasDot)
					dotDigit = true;
				hasDigit = true;
				i++;
				continue;
			}
			if(str[i] == 'e' || str[i] == 'E') {
				if(hasE || !hasDigit || (hasDot && !dotDigit))
					return false;
				hasE = true;
				// treat e/E as separator
				hasDigit = false;
				hasDot = false;
				hasSign = false;
				i++;
				continue;
			}
			if(str[i] == '.') {
				if(hasDot || hasE)
					return false;
				dotDigit = hasDigit;
				hasDot = true;
				i++;
				continue;
			}
			if(str[i] == '+' || str[i] == '-') {
				if(hasDigit || hasSign || hasDot)
					return false;
				hasSign = true;
				i++;
				continue;
			}
			return false;
		}
		if((hasE && !eDigit) || (hasDot && !dotDigit) || (!hasE && !hasDigit))
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		String s = " 005047e+6";
		System.out.println(new ValidNumber().isNumber(s));
	}
}
