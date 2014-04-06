package net.wentaochang.leetcode;

public class BestTimetoBuyandSellStockIII {
	// time limit exceeds
	/*
	 * public int maxProfit(int[] prices) { int max = 0; for (int i = 0; i <=
	 * prices.length - 1; i++) { int val = max(prices, 0, i) + max(prices, i +
	 * 1, prices.length - 1); if (val > max) { max = val; } } return max; }
	 * 
	 * private int max(int[] prices, int start, int end) { if (start >= end) {
	 * return 0; } int max = 0; int min = Integer.MAX_VALUE; for (int i = start;
	 * i <= end; i++) { if (prices[i] - min > max) { max = prices[i] - min; } if
	 * (prices[i] < min) { min = prices[i]; } } return max; }
	 */

	// pay attention to buffer overflow
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int[] forward = new int[prices.length];
		long max = 0;
		long min = Integer.MAX_VALUE;
		for (int i = 0; i <= prices.length - 1; i++) {
			if (prices[i] - min > max) {
				max = (int) (prices[i] - min);
			}
			if (prices[i] < min) {
				min = prices[i];
			}
			forward[i] = (int) max;
		}
		int[] backward = new int[prices.length];
		max = Integer.MIN_VALUE;
		min = 0;
		for (int i = prices.length - 1; i >= 0; i--) {
			if (prices[i] - max < min) {
				min = prices[i] - max;
			}
			if (prices[i] > max) {
				max = prices[i];
			}
			backward[i] = (int) -min;
		}
		max = 0;
		for (int i = 0; i <= prices.length - 1; i++) {
			int val = forward[i] + (i == prices.length - 1 ? 0 : backward[i + 1]);
			if (val > max) {
				max = val;
			}
		}
		return (int) max;
	}

	public static void main(String[] args) {
		int[] prices = { 1, 2 };
		maxProfit(prices);
	}
}
