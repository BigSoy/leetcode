package problems;

import java.util.LinkedList;

public class SimplifyPath {

	public static void main(String[] args) {
		String path = "/.";
		System.out.println(new SimplifyPath().simplifyPath(path));
	}

	public String simplifyPath(String path) {
		if(path == null || path.length() == 0)
			return "/";
		LinkedList<String> list = new LinkedList<String>();
		int len = path.length();
		int i = 0;
		while(i < len) {
			while(i < len && '/' == path.charAt(i))
				i++;
			if(i == len)
				break;
			if('.' == path.charAt(i)) {
				if(i+1 < len) {
					if('.' == path.charAt(i+1) && (i+2 == len || '/' == path.charAt(i+2))) {
						if(!list.isEmpty())
							list.removeLast();
						i += 3;
					} else if('/' == path.charAt(i+1)) {
						i += 2;
					} else {
						int j = i;
						while(i < len && '/' != path.charAt(i))
							i++;
						list.add(path.substring(j, i));
						i++;
					}
				} else
					break;
			} else {
				int j = i;
				while(i < len && '/' != path.charAt(i))
					i++;
				list.add(path.substring(j, i));
				i++;
			}
		}
		StringBuffer sb = new StringBuffer();
		while(!list.isEmpty())
			sb.append("/" + list.removeFirst());
		if(sb.length() == 0)
			sb.append("/");
		return sb.toString();
	}
}
