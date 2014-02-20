package problems;

public class IntegerToRoman {

	public static void main(String[] args) {
		int num = 3999;
		String result = new IntegerToRoman().intToRoman(num);
		System.out.println(result);
	}
	
	public String intToRoman(int num) {
		String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int[] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		StringBuffer sb = new StringBuffer();
		for(int i=0; num!=0; i++) {
			while(num >= value[i]) {
				sb.append(symbol[i]);
				num -= value[i];
			}
		}
		return sb.toString();
	}

}
