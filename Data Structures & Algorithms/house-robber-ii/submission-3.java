class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        
        int option1 = solveLinear(nums, 0, n - 2);        
        int option2 = solveLinear(nums, 1, n - 1);
        
        return Math.max(option1, option2);
    }

    private int solveLinear(int[] nums, int start, int end) {
        if (start > end) return 0;
        if (start == end) return nums[start];

        int n = end - start + 1;
        int[] dp = new int[n];

        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[start + i] + dp[i - 2], dp[i - 1]);
        }

        return dp[n - 1];
    }
}