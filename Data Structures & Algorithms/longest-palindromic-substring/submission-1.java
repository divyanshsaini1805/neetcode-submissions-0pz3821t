class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Case 1: Center is a single character (e.g., "aba")
            int len1 = expandFromCenter(s, i, i);
            // Case 2: Center is between two characters (e.g., "abba")
            int len2 = expandFromCenter(s, i, i + 1);
            
            int maxLen = Math.max(len1, len2);
            
            // Update the global start and end if a longer palindrome is found
            if (maxLen > (end - start)) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Returns the length of the palindrome found
        // Formula: (right - 1) - (left + 1) + 1 = right - left - 1
        return right - left - 1;
    }
}