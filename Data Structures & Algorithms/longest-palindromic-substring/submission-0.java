class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
    String t = new StringBuilder(s).reverse().toString();
    int[][] dp = new int[n + 1][n + 1];
    int maxLen = 0;
    int lastIdx = 0;

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                dp[i][j] = 1 + dp[i - 1][j - 1];
                
                // Verification check: Is this common substring actually a palindrome?
                if (dp[i][j] > maxLen) {
                    int originalIdx = i - 1;
                    int reversedIdxInOriginal = n - j;
                    if (originalIdx - dp[i][j] + 1 == reversedIdxInOriginal) {
                        maxLen = dp[i][j];
                        lastIdx = i;
                    }
                }
            }
        }
    }
    return s.substring(lastIdx - maxLen, lastIdx);
    }
}
