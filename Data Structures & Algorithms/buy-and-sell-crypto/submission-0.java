class Solution {
    public int maxProfit(int[] prices) {
        int low = prices[0];
        int profit = 0;

        for(int i=1; i<prices.length; i++){
            int diff = prices[i] - low;
            profit = Math.max(diff, profit);
            low = Math.min(low, prices[i]);
        }

        return profit;
    }
}
