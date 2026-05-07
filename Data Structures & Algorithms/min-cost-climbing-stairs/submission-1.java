class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1]; 
        
        dp[0] = 0; 
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            // Option 1: Come from i-1 and pay the cost[i-1]
            // Option 2: Come from i-2 and pay the cost[i-2]
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], 
                             dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }
}