package problems;

/**
 * Reference : http://www.cnblogs.com/TenosDoIt/p/3436457.html
 * @author ls
 *
 */
public class BestTimeToBuyAndSellStockIII {

	public static void main(String[] args) {
		int[] prices = {1,2,3,4};
		int result = new BestTimeToBuyAndSellStockIII().maxProfit(prices);
		System.out.println(result);
	}
	
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length < 2)
			return 0;
		int maxProfit = 0;
		
		int[] maxFromHead = new int[prices.length];
		maxFromHead[0] = 0;
		int curLowest = prices[0];
		for(int i=1; i<prices.length; i++) {
			maxFromHead[i] = Math.max(prices[i] - curLowest, maxFromHead[i-1]);
			curLowest = prices[i] < curLowest ? prices[i] : curLowest;
		}
		int maxFromTail = 0;
		int curHighest = prices[prices.length-1];
		for(int i=prices.length-1; i>0; i--) {
			maxFromTail = Math.max(curHighest - prices[i], maxFromTail);
			curHighest = prices[i] > curHighest ? prices[i] : curHighest;
			maxProfit = Math.max(maxFromHead[i-1] + maxFromTail, maxProfit);
		}
		maxProfit = Math.max(maxProfit, maxFromHead[prices.length-1]);
		return maxProfit;
    }

}
