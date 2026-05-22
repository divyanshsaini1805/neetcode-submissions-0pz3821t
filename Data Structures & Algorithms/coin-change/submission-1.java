class Solution {

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        int INF = (int)1e9;

        int[][] dp = new int[n + 1][amount + 1];

        // Initialize all cells with INF
        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }

        // Base case:
        // amount 0 requires 0 coins
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        // Fill table bottom-up
        for(int i = n - 1; i >= 0; i--) {

            for(int a = 1; a <= amount; a++) {

                // Skip current coin
                int noTake = dp[i + 1][a];

                // Take current coin
                int take = INF;

                if(a >= coins[i]) {
                    take = 1 + dp[i][a - coins[i]];
                }

                dp[i][a] = Math.min(take, noTake);
            }
        }

        return dp[0][amount] >= INF
                ? -1
                : dp[0][amount];
    }
}