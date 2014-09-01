package problems;

/**
 * Differences with problem "WildcardMatching" : 
 * Different "*" needs different "star & star_match"
 * We need to use stack to reserve every star & star_match, thus we'd better solve it recursively 
 * @author ls
 *
 */
public class RegularExpressionMatching {

	public boolean isMatch(String s, String p) {
		if(p.isEmpty())
			return s.isEmpty();
		// handle with '*'
		if(p.length() > 1 && p.charAt(1) == '*') {
			if(isMatch(s, p.substring(2)))
				return true;
			String ss = new String(s);
			while(!ss.isEmpty() && (ss.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
				ss = ss.substring(1);
				if(isMatch(ss, p.substring(2)))
					return true;
			}
			return false;
		} else {
			return (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) 
					&& isMatch(s.substring(1), p.substring(1));
		}
	}
	
	public static void main(String[] args) {
		String s = "aab";
		String p = "c*a*b";
		System.out.println(new RegularExpressionMatching().isMatch(s, p));
	}
}
