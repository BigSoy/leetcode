package problems;

/**
 * Newton's method
 * @author ls
 */
public class Sqrtx {

	public int sqrt(int x) {
		double cur = 1;
		double pre = Integer.MIN_VALUE;
		while(Math.abs(cur-pre) > 0.00001) {
			if(cur*cur == x)
				return (int)cur;
			pre = cur;
			cur = (cur*cur + x) / (2*cur);
		}
		return (int)cur;
	}
	
	public static void main(String[] args) {
		int x = 4;
		System.out.println(new Sqrtx().sqrt(x));
	}
}
