package problems;

public class ReverseInteger {

	public static void main(String[] args) {
		int x = 0;
		int y = new ReverseInteger().reverse(x);
		System.out.println(y);
	}
	
	public int reverse(int x) {
		char[] chars = String.valueOf(x).toCharArray();
		StringBuffer sb = new StringBuffer();
		int begin, end;
		if(chars[0] == '-') {
			begin = 1;
			sb.append("-");
		} else
			begin = 0;
		end = chars.length - 1;
		while(end >= begin && chars[end] == '0')
			end--;
		for(int i=end; i>=begin; i--)
			sb.append(chars[i]);
		if(sb.length() == 0 || (sb.length()==1 && sb.charAt(0)=='-'))
			return 0;
		else
			return Integer.parseInt(sb.toString());
	}

}
