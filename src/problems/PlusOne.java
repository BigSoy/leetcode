package problems;

public class PlusOne {

	public static void main(String[] args) {
		int[] d = {9};
		int[] result = new PlusOne().plusOne(d);
		for(int i=0; i<result.length; i++) {
			System.out.print(String.valueOf(result[i]) + " \n".charAt(i==(result.length-1) ? 1:0));
		}
	}

	public int[] plusOne(int[] digits) {
		int[] tmp = new int[digits.length];
		int[] result = null;
		int c = 1;
		boolean overflow = false;
		for(int i=digits.length-1; i>=0; i--) {
			if(digits[i] + c == 10) {
				tmp[i] = 0;
				c = 1;
				if(i == 0)
					overflow = true;
			} else {
				tmp[i] = digits[i] + c;
				c = 0;
			}
		}
		if(overflow) {
			result = new int[digits.length+1];
			System.arraycopy(tmp, 0, result, 1, digits.length);
			result[0] = 1;
		} else {
			result = new int[digits.length];
			System.arraycopy(tmp, 0, result, 0, digits.length);
		}
		return result;
    }
	
}
