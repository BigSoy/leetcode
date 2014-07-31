package problems;

public class MultiplyStrings {

	public String multiply(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		int[] n1 = new int[len1];
		int[] n2 = new int[len2];
		int[] result = new int[len1 + len2];
		
		for(int i=0; i<len1; i++)
			n1[i] = num1.charAt(len1-1-i) - '0';
		for(int i=0; i<len2; i++)
			n2[i] = num2.charAt(len2-1-i) - '0';
		for(int j=0; j<len2; j++) {
			for(int i=0; i<len1; i++) {
				result[i+j] += n1[i]*n2[j];
			}
		}
		for(int k=0; k<len1+len2; k++) {
			if(result[k] > 9) {
				result[k+1] += result[k] / 10;
				result[k] = result[k] % 10;
			}
		}
		StringBuffer sb = new StringBuffer();
		int k = len1+len2-1;
		while(k>0 && result[k] == 0) k--;
		while(k>=0) {
			sb.append(result[k]);
			k--;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String num1 = "1";
		String num2 = "0";
		String result = new MultiplyStrings().multiply(num1, num2);
		System.out.println(result);
	}

}
