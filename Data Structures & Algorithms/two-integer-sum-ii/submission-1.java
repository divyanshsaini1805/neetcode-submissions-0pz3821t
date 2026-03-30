class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0; int j=numbers.length - 1;

        while(i < j && i!= j && i<=numbers.length - 1 && j >= 0){
            if(numbers[i] + numbers[j] < target)
                i++;
            else if(numbers[i] + numbers[j] > target)
                j--;
            else{
                int[] ans = new int[2];
                ans[0] = i+1; ans[1] = j+1;
                return ans; 
            }
        }
        return new int[0];
    }
}
