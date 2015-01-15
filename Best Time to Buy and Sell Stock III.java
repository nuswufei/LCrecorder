public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int[] leftMax = new int[prices.length];
        int min = prices[0];
        int maxprofit = 0;
        for(int i = 1; i < prices.length; ++i) {
            maxprofit = Math.max(maxprofit, prices[i] - min);
            leftMax[i] = maxprofit;
            min = Math.min(min, prices[i]);
        }
        int[] rightMax = new int[prices.length];
        int max = prices[prices.length - 1];
        maxprofit = 0;
        for(int i = prices.length - 2; i >= 0; --i) {
            maxprofit = Math.max(maxprofit, max - prices[i]);
            rightMax[i] = maxprofit;
            max = Math.max(max, prices[i]);
        }
        maxprofit = rightMax[0];
        for(int i = 0; i < prices.length - 1; ++i) {
            maxprofit = Math.max(maxprofit, leftMax[i] + rightMax[i + 1]);
        }
        return maxprofit;
    }
}
