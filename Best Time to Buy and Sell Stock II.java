public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int max = 0;
        for(int i = 1; i < prices.length; ++i)  max = prices[i] - prices[i - 1] > 0 ? max + prices[i] - prices[i - 1] : max;
        return max;
    }
}
