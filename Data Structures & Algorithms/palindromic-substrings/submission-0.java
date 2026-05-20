class Solution {
    public int countSubstrings(String s) {
        int totalPalindromes = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd-length palindromes (Center is s.charAt(i))
            totalPalindromes += expandFromCenter(s, i, i);
            
            // Case 2: Even-length palindromes (Center is between i and i+1)
            totalPalindromes += expandFromCenter(s, i, i + 1);
        }
        
        return totalPalindromes;
    }
    
    private int expandFromCenter(String s, int left, int right) {
        int count = 0;
        // Expand outwards as long as it's a valid palindrome
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;  // Move left pointer outward
            right++; // Move right pointer outward
        }
        return count;
    }
}