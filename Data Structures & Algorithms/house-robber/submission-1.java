class Solution {
    private int solve(int[] nums, int i, int n, int[] dp){
        if(i >= n) return 0;
        // Check against -1 instead of 0
        if(dp[i] != -1) return dp[i]; 
        
        return dp[i] = Math.max(nums[i] + solve(nums, i + 2, n, dp), solve(nums, i + 1, n, dp));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        java.util.Arrays.fill(dp, -1); // Initialize all to -1
        return solve(nums, 0, n, dp);
    }
}