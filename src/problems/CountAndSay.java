package problems;

public class CountAndSay {

	public String countAndSay(int n) {
		String s = "1";
		while(n > 1) {
			int count = 1;
			int num = s.charAt(0) - '0';
			String next_s = "";
			for(int i=1; i<s.length(); i++) {
				if(s.charAt(i) - '0' == num)
					count++;
				else{
					next_s += count + "" + num;
					count = 1;
					num = s.charAt(i) - '0';
				}
			}
			next_s += count + "" + num;
			s = next_s;
			n--;
		}
		return s;
	}
	
	public static void main(String[] args) {
		int n = 1;
		String result = new CountAndSay().countAndSay(n);
		System.out.println(result);
	}
}
