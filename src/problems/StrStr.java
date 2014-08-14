package problems;

/**
 * KMP
 * @author ls
 */
public class StrStr {

	private int[] findNext(String needle) {
		int len = needle.length();
		int[] next = new int[len];
		next[0] = -1;
		int i = 0;
		int k = -1;
		while(i < len) {
			while(k >= 0 && needle.charAt(k) != needle.charAt(i))
				k = next[k];
			i++;
			k++;
			if(i == len)
				break;
			// optimization
			// BUT k must not be modified here
			if(needle.charAt(k) == needle.charAt(i))
				next[i] = next[k];
			else
				next[i] = k;
		}
		return next;
	}
	
	public String strStr(String haystack, String needle) {
		if(haystack == null || needle == null)
			return null;
		int n = haystack.length();
		int m = needle.length();
		if(m == 0)
			return haystack;
		if(n < m)
			return null;
		
		int[] next = findNext(needle);
		int j = 0;
		for(int i=0; i<n; i++) {
			if(j < m && haystack.charAt(i) == needle.charAt(j))
				j++;
			else {
				if(j == m)
					return haystack.substring(i-m);
				while(j >= 0 && haystack.charAt(i) != needle.charAt(j))
					j = next[j];
				j++;
			}
		}
		if(j == m)
			return needle;
		else
			return null;
	}
	
	public static void main(String[] args) {
		String haystack = "rraabdcqq";
		String needle = "aabdc";
		System.out.println(new StrStr().strStr(haystack, needle));
	}
}
