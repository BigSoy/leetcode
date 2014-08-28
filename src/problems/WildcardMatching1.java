package problems;

public class WildcardMatching1 {

	public boolean isMatch(String s, String p) {
		int i = 0;
		int j = 0;
		int star = -1;
		int star_match = -1;
		while(i < s.length()) {
			if(j == p.length()) {
				if(star >= 0) {
					i = star_match + 1;
					j = star + 1;
					star_match++;
					continue;
				} else
					return false;
			}
			if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
				i++;
				j++;
				continue;
			}
			if(p.charAt(j) == '*') {
				star = j;
				star_match = i;
				j++;
				continue;
			}
			// backtrack when s[i] != p[j]
			if(star >= 0) {
				i = star_match + 1;
				j = star + 1;
				star_match++;
				continue;
			}
			return false;
		}
		while(j < p.length() && p.charAt(j) == '*') j++;
		return j == p.length();
	}
	
	public static void main(String[] args) {
		String s = "aab";
		String p = "c*a*b";
		System.out.println(new WildcardMatching1().isMatch(s, p));
	}
}
