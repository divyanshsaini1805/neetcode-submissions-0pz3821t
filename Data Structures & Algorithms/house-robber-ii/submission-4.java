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
        int prev = nums[start];
        int next = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < n; i++) {
            int temp = Math.max(nums[start + i] + prev, next);
            // next = prev;
            prev = next;
            next = temp;
        }

        return next;
    }
}