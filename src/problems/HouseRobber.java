package problems;

public class HouseRobber {

	public int rob(int[] num) {
		if(num == null || num.length == 0)
			return 0;
		if(num.length == 1)
			return num[0];
		if(num.length == 2)
			return Math.max(num[0], num[1]);
		if(num.length == 3)
			return Math.max(num[0] + num[2], num[1]);
		int[] amount = new int[num.length];
		amount[0] = num[0];
		amount[1] = num[1];
		amount[2] = num[0] + num[2];
		for(int i=3; i<amount.length; i++)
			amount[i] = Math.max(amount[i-2], amount[i-3]) + num[i];
		return Math.max(amount[amount.length-1], amount[amount.length-2]);
    }
	
	public static void main(String[] args) {
		int[] num = {1,1,2,1};
		System.out.println(new HouseRobber().rob(num));
	}

}
