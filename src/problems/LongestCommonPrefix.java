package problems;

public class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0)
			return "";
		String prefix = strs[0];
		for(int i=1; i<strs.length; i++) {
			int len = prefix.length();
			if(strs[i].length() < len)
				len = strs[i].length();
			
			if(len == 0)
				return "";
			
			int j = 0;
			for(j=0; j<len; j++) {
				if(prefix.charAt(j) != strs[i].charAt(j))
					break;
			}
			prefix = prefix.substring(0, j);
		}
		return prefix;
	}

}
