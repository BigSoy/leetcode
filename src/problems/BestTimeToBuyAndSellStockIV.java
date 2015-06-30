package problems;

public class BestTimeToBuyAndSellStockIV {
	
	/*
	 * Reference : http://blog.csdn.net/linhuanmars/article/details/23236995
	 */
	public int maxProfit(int k, int[] prices) {
		boolean buyed = false;
        int total = 0;
        int times = 0;
        int n = prices.length;
        for(int i=0; i<n; i++) {
            if(!buyed && i+1 < n && prices[i+1] > prices[i]) {
                total -= prices[i];
                buyed = true;
            } else if(buyed && (i+1 == n || prices[i+1] < prices[i])) {
                total += prices[i];
                buyed = false;
                times++;
            }
        }
		if(k >= times)
			return total;
		int[][] local = new int[n][k+1];
		int[][] global = new int[n][k+1];
		for(int i=1; i<n; i++) {
			for(int j=1; j<=k; j++) {
				int diff = prices[i] - prices[i-1];
				local[i][j] = Math.max(global[i-1][j-1] + Math.max(diff, 0), local[i-1][j] + diff);
				global[i][j] = Math.max(global[i-1][j], local[i][j]);
			}
		}
		return global[n-1][k];
	}

}
