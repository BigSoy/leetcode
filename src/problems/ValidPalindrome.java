package problems;

public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		if(s == null)
			return false;
		if(s.isEmpty())
			return true;
		char[] chArr = s.toLowerCase().toCharArray();
		int i = 0;
		int j = chArr.length - 1;
		while(i < j) {
			while(i < j && !Character.isDigit(chArr[i]) && !Character.isLowerCase(chArr[i]))
				i++;
			while(j > i && !Character.isDigit(chArr[j]) && !Character.isLowerCase(chArr[j]))
				j--;
			if(i < j) {
				if(chArr[i] != chArr[j])
					return false;
				i++;
				j--;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(new ValidPalindrome().isPalindrome(s));
	}
}
