class Solution {
    private int solve(int i, int n, int[] dp){
        if(i > n) return 0;
        if(i == n) return 1;
        if(dp[i] != 0) return dp[i];

        return dp[i] = solve(i+1, n, dp) + solve(i+2,n, dp);
    } 

    public int climbStairs(int n) {
        int[] dp = new int[n];
        return solve(0, n, dp);
    }
}
