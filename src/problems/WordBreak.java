package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Approach : (DP) From top to bottom
 * Reference : http://www.cnblogs.com/lautsie/p/3371354.html
 * @author latitude
 *
 */
public class WordBreak {

	private int[][] wordBreak = null;
	
	private boolean wordBreak(String s, Set<String> dict, int i, int j) {
		if(wordBreak[i][j] == 1)
			return true;
		if(wordBreak[i][j] == -1)
			return false;
		if(dict.contains(s.substring(i, j+1))) {
			wordBreak[i][j] = 1;
			return true;
		}
		for(int k=i; k<j; k++) {
			if(wordBreak(s, dict, i, k) && wordBreak(s, dict, k+1, j)) {
				wordBreak[i][j] = 1;
				return true;
			}
		}
		wordBreak[i][j] = -1;
		return false;
	}
	
	public boolean wordBreak(String s, Set<String> dict) {
		if(s == null || s.length() == 0 || dict == null || dict.size() == 0)
			return false;
		wordBreak = new int[s.length()][s.length()];
		for(int i=0; i<wordBreak.length; i++)
			Arrays.fill(wordBreak[i], 0);
		return wordBreak(s, dict, 0, s.length()-1);
	}
	
	public static void main(String[] args) {
		String s = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		boolean result = new WordBreak().wordBreak(s, dict);
		System.out.println(result);
	}
}
