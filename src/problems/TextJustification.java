package problems;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public List<String> fullJustify(String[] words, int L) {
		List<String> result = new ArrayList<String>();
		int index = 0;
		while(index < words.length) {
			int len = words[index].length();
			int i = index;
			while(i+1 < words.length && len + 1 + words[i+1].length() <= L) {
				len += 1 + words[i+1].length();
				i++;
			}
			// words[i] is the last word in the current line now
			// if this line contains only one word 
			if(i == index) {
				String line = words[index];
				while(line.length() < L)
					line += " ";
				result.add(line);
			}
			// if this line is the last line
			else if(i == words.length - 1) {
				String line = words[index];
				for(int j=index+1; j<=i; j++)
					line += " " + words[j];
				while(line.length() < L)
					line += " ";
				result.add(line);
			} else {
				int words_num = i - index + 1;
				int spaces_len = L;
				for(int j=index; j<=i; j++)
					spaces_len -= words[j].length();
				int sp_len = spaces_len/(words_num-1);
				
				// construct the space strings
				String space = "";
				for(int k=0; k<sp_len; k++)
					space += " ";
				int r = spaces_len - sp_len*(words_num-1);
				
				String line = words[index];
				for(int j=index+1; j<=i; j++) {
					if(r-- > 0)
						line += " ";
					line += space + words[j];
				}
				result.add(line);
			}
			index = i + 1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		int L = 16;
		List<String> result = new TextJustification().fullJustify(words, L);
		for(String line : result)
			System.out.println(line);
	}
}
