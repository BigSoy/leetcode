package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {

	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> result = new ArrayList<Integer>();
		if(L == null || L.length == 0)
			return result;
		int word_size = L[0].length();
		Map<String, Integer> words = new HashMap<String, Integer>();
		Map<String, Integer> count = new HashMap<String, Integer>();
		for(String ss : L) {
			if(words.containsKey(ss))
				words.put(ss, words.get(ss)+1);
			else
				words.put(ss, 1);
		}
		int lastIndex = S.length()-L.length*word_size;
		for(int i=0; i<=lastIndex; i++) {
			count.clear();
			int j;
			for(j=0; j<L.length; j++) {
				String word = S.substring(i+j*word_size, i+(j+1)*word_size);
				if(!words.containsKey(word))
					break;
				if(!count.containsKey(word)) {
					count.put(word, 1);
				} else if(count.get(word) == words.get(word)) {
					break;
				} else {
					count.put(word, count.get(word)+1);
				}
			}
			if(j == L.length)
				result.add(i);
		}
		return result;
	}
	
	public static void main(String[] args) {
		String S = "barfoothefoobarman";
		String[] L = {"foo", "bar"};
		List<Integer> result = new SubstringWithConcatenationOfAllWords().findSubstring(S, L);
		for(int i : result)
			System.out.print(i + " ");
	}
}
