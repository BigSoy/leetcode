package problems;

public class Pow_X_N {

	public static void main(String[] args) {
		double result = new Pow_X_N().pow(1, -2147483648);
		System.out.println(result);
	}

	public double pow(double x, int n) {
		if(n == 0)
			return 1;
		double half = pow(x, Math.abs(n/2));
		double result;
		if(n % 2 == 0)
			result = half * half;
		else
			result = half * half * x;
		if(n < 0)
			result = 1.0 / result;
		return result;
	}
}
