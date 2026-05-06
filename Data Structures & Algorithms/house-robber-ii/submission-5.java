class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        
        int option1 = solveLinear(nums, 0, n - 2);        
        int option2 = solveLinear(nums, 1, n - 1);
        
        return Math.max(option1, option2);
    }

    private int solveLinear(int[] nums, int start, int end) {
    int prev2 = 0; // Two steps back
    int prev1 = 0; // One step back

    for (int i = start; i <= end; i++) {
        int current = Math.max(prev1, prev2 + nums[i]);
        prev2 = prev1;
        prev1 = current;
    }

    return prev1;
}
}