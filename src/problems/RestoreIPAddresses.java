package problems;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	private void dfs(String s, int pos, int n, String ip, List<String> res) {
		if(n == 4) {
			if(pos == s.length())
				res.add(new String(ip));
			return;
		}
		if(pos >= s.length())
			return;
		for(int i=1; i<=3; i++) {
			if(pos+i <= s.length()) {
				String ss = s.substring(pos, pos+i);
				int num = Integer.parseInt(ss);
				if(i >= 2 && (ss.charAt(0) == '0' || num > 255))
					break;
				if(n == 0) {
					ip += ss;
					dfs(s, pos+i, n+1, ip, res);
					ip = ip.substring(0, ip.length()-i);
				}
				else {
					ip += "." + ss;
					dfs(s, pos+i, n+1, ip, res);
					ip = ip.substring(0, ip.length()-i-1);
				}
			}
		}
	}
	
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		if(s.length() < 4 || s.length() > 12)
			return result;
		String ip = "";
		dfs(s, 0, 0, ip, result);
		return result;
	}
	
	public static void main(String[] args) {
		String s = "25525511135";
		List<String> result = new RestoreIPAddresses().restoreIpAddresses(s);
		for(String ip : result)
			System.out.println(ip);
	}
}
