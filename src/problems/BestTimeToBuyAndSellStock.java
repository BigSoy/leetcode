package problems;

public class BestTimeToBuyAndSellStock {
	
	public static void main(String[] args) {
		int[] prices = {1,2,3,4};
		int result = new BestTimeToBuyAndSellStock().maxProfit(prices);
		System.out.println(result);
	}
	
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length < 2)
			return 0;
		int maxProfit = 0;
		int curLowest = prices[0];
        for(int i=1; i<prices.length; i++) {
        	if(prices[i] - curLowest > maxProfit)
        		maxProfit = prices[i] - curLowest;
        	if(prices[i] < curLowest)
        		curLowest = prices[i];
        }
        return maxProfit;
    }

}
