package problems;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

	public String convert(String s, int nRows) {
		int len = s.length();
		if(len <= 1 || nRows == 1)
			return new String(s);
		int groupSize = 2*nRows - 2;
		List<String> groups = new ArrayList<String>();
		int groupStart = 0;
		for(int i=1; i<len; i++) {
			if(i%groupSize == 0) {
				groups.add(s.substring(groupStart, i));
				groupStart = i;
			}
		}
		groups.add(s.substring(groupStart, len));
		
		StringBuffer sb = new StringBuffer();
		for(int row=0; row<nRows; row++) {
			for(String str : groups) {
				if(row == 0) {
					sb.append(str.charAt(0));
				} else if(row == nRows-1) {
					if(row < str.length())
						sb.append(str.charAt(row));
				} else {
					if(row < str.length())
						sb.append(str.charAt(row));
					if(groupSize - row < str.length())
						sb.append(str.charAt(groupSize - row));
				}
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int nRows = 3;
		System.out.println(new ZigZagConversion().convert(s, nRows));
	}
}
