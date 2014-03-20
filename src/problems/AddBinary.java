package problems;

public class AddBinary {

	public static void main(String[] args) {
		String a = "0";
		String b = "";
		System.out.println(new AddBinary().addBinary(a, b));
	}
	
	public String addBinary(String a, String b) {
		int m = a.length();
		int n = b.length();
		char[] ret = new char[Math.max(m, n)];
		boolean c = false;
		int i = m-1, j = n-1, k = ret.length-1;
		while(i >= 0 && j >= 0) {
			if('1' == a.charAt(i) && '1' == b.charAt(j)) {
				ret[k--] = c ? '1' : '0';
				c = true;
			} else if('0' == a.charAt(i) && '0' == b.charAt(j)) {
				ret[k--] = c ? '1' : '0';
				c = false;
			} else {
				ret[k--] = c ? '0' : '1';
			}
			i--;
			j--;
		}
		while(i >= 0) {
			if('1' == a.charAt(i)) {
				ret[k--] = c ? '0' : '1';
			} else {
				ret[k--] = c ? '1' : '0';
				c = false;
			}
			i--;
		}
		while(j >= 0) {
			if('1' == b.charAt(j)) {
				ret[k--] = c ? '0' : '1';
			} else {
				ret[k--] = c ? '1' : '0';
				c = false;
			}
			j--;
		}
		if(c)
			return "1" + new String(ret);
		return new String(ret);
	}
}
