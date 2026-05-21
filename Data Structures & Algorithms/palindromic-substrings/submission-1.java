class Solution {
    private int isPalindrome(int left, int right, String s){
        int cnt = 0;
        while(left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)){
            left--; right++;
            cnt++;
        }
        return cnt;
    }
    public int countSubstrings(String s) {
        int n = s.length();
        int cnt = 0;

        for(int i=0; i<n; i++){
            cnt += isPalindrome(i,i,s);
            cnt += isPalindrome(i,i+1,s);
        }
    return cnt;
    }
}
