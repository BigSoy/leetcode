package problems;

/**
 * 1.设定数组long[] sum, long[] r, 空间换时间
 * 2.注意整数的取值范围
 * @author ls
 *
 */
public class DivideTwoIntegers {

	public static void main(String[] args) {
		int result = new DivideTwoIntegers().divide(2147483647, 2);
		System.out.println(result);
	}

	public int divide(int dividend, int divisor) {
		//System.out.println(Integer.MIN_VALUE + " " + Integer.MAX_VALUE);
		long left = Math.abs((long)dividend);
		long d = Math.abs((long)divisor);
		long[] sum = new long[50];
		long[] r = new long[50];
		sum[0] = d;
		r[0] = 1;
		int i;
		for (i = 1; sum[i-1] < left; i++) {
			sum[i] = sum[i-1] + sum[i-1];
			r[i] = r[i-1] + r[i-1];
		}
		i--;
		int s = 0;
		while (left >= d) {
			if (left >= sum[i]) {
				left -= sum[i];
				s += r[i];
			}
			i--;
		}
        return (long)dividend*(long)divisor >= 0 ? s : -s;
    }
}
