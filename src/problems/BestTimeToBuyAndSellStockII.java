package problems;

public class BestTimeToBuyAndSellStockII {

	public static void main(String[] args) {
		int[] prices = {5,1,2,4,3,4,2};
		int result = new BestTimeToBuyAndSellStockII().maxProfit(prices);
		System.out.println(result);
	}
	
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length < 2)
			return 0;
		int maxProfit = 0;
		int buyDay = 0;
		int sellDay = 0;
		int i = 1;
		while(i < prices.length) {
			while(i < prices.length && prices[i] <= prices[i-1]) {
				buyDay = i++;
			}
			while(i < prices.length && prices[i] >= prices[i-1]) {
				sellDay = i++;
			}
			if(buyDay < sellDay)
				maxProfit += prices[sellDay] - prices[buyDay];
		}
		return maxProfit;
    }

}
