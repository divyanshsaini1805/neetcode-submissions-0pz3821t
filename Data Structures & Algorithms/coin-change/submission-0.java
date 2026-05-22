class Solution {

    int[][] dp;

    private int solve(int[] coins, int amount, int i) {

        // exact amount formed
        if(amount == 0)
            return 0;

        // no coins left
        if(i == coins.length)
            return Integer.MAX_VALUE;

        // already computed
        if(dp[i][amount] != -1)
            return dp[i][amount];

        int take = Integer.MAX_VALUE;

        // take current coin
        if(amount >= coins[i]) {

            int res = solve(coins, amount - coins[i], i);

            if(res != Integer.MAX_VALUE) {
                take = 1 + res;
            }
        }

        // skip current coin
        int noTake = solve(coins, amount, i + 1);

        return dp[i][amount] = Math.min(take, noTake);
    }

    public int coinChange(int[] coins, int amount) {

        dp = new int[coins.length][amount + 1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = solve(coins, amount, 0);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}