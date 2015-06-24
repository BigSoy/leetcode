package problems;

import java.util.HashMap;

public class FractionToRecurringDecimal {

	public String fractionToDecimal(int numerator, int denominator) {
		if(numerator == 0)
			return "0";
		StringBuilder result = new StringBuilder();
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		boolean f = true;
		boolean neg = (numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0) ? true : false;
		if(neg)
			result.append('-');
		long nu = Math.abs((long)numerator);
		long de = Math.abs((long)denominator);
		long q = nu / de;
		long r = nu % de;
		result.append(q);
		while(r != 0) {
			if(f) {
				result.append('.');
				f = false;
			}
			if(map.containsKey(r)) {
				int pos = map.get(r);
				result.insert(pos, '(');
				result.append(')');
				break;
			}
			map.put(r, result.length());
			r *= 10;
			q = r / de;
			r = r % de;
			result.append(q);
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		int numerator = 2;
		int denominator = 3;
		System.out.println(new FractionToRecurringDecimal().fractionToDecimal(numerator, denominator));
	}

}
