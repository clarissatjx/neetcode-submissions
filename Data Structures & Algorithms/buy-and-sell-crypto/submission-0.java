class Solution {
    public int maxProfit(int[] prices) {
        int lowest = prices[0];
        int bestProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            bestProfit = Math.max(bestProfit, prices[i] - lowest);
            lowest = Math.min(prices[i], lowest);
        }

        return bestProfit;
        
    }
}
