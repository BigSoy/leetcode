package problems;

public class DecodeWays {

	public static void main(String[] args) {
		String s = "101";
		System.out.println(new DecodeWays().numDecodings(s));
	}

	public int numDecodings(String s) {
		if(s == null || s.length() == 0 || '0' == s.charAt(0))
			return 0;
		if(s.length() == 1)
			return 1;
		int len = s.length();
		int[] waysNum = new int[len];
		waysNum[0] = 1;
		waysNum[1] = '0'==s.charAt(1) ? 0 : 1;
		int p = Integer.parseInt(s.substring(0, 2));
		if(p >= 1 && p <= 26)
			waysNum[1]++;
		for(int i=2; i<len; i++) {
			waysNum[i] = '0'==s.charAt(i) ? 0 : waysNum[i-1];
			if('1' == s.charAt(i-1) || ('2' == s.charAt(i-1) && s.charAt(i) <= '6'))
				waysNum[i] += waysNum[i-2];
		}
		return waysNum[len-1];
	}
}
