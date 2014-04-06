package net.wentaochang.leetcode;

public class BestTimetoBuyandSellStockII {
    /*public int maxProfit(int[] prices) {
        int totalProfit = 0;
        int start = prices[0];
        for(int i=1;i<prices.length;++i){
        	if(prices[i] < prices[i-1]){
        		totalProfit += (prices[i-1] - start);
        		start = prices[i];
        	}
        }
        totalProfit += (prices[prices.length-1] - start);
        return totalProfit;
    }*/
    
    public int maxProfit(int[] prices) {
		int p = 0;
		for (int i = 1; i < prices.length; i++) {
			int delta = prices[i] - prices[i - 1];
			if (delta > 0)
				p += delta;

		}
		return p;        
    }
}
