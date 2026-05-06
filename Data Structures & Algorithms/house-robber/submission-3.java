class Solution {
    private int solve(int[] nums, int i, int n, int[] dp){
    
        for(i=n-1; i>=0; i--){
            dp[i] = Math.max(nums[i] + dp[i + 2], 
                    dp[i + 1]);
        }
        return dp[0];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+2];
        // java.util.Arrays.fill(dp, -1); // Initialize all to -1
        return solve(nums, 0, n, dp);
    }
}