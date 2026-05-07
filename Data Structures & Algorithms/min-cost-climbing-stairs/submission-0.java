class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        java.util.Arrays.fill(dp, -1);
        
        // We can finish at the very top by coming from either of the last two steps
        return Math.min(solve(cost, n - 1, dp), solve(cost, n - 2, dp));
    }

    private int solve(int[] cost, int i, int[] dp) {
        if (i < 0) return 0;
        if (i == 0 || i == 1) return cost[i];
        if (dp[i] != -1) return dp[i];

        return dp[i] = cost[i] + Math.min(solve(cost, i - 1, dp), solve(cost, i - 2, dp));
    }
}