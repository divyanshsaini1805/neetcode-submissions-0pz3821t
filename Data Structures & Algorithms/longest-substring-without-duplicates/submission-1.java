class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);

        int l = 0;
        for (int r = 0; r < n; r++) {
            char currentChar = s.charAt(r);

            if (lastSeen[currentChar] >= l) {
                l = lastSeen[currentChar] + 1;
            }

            lastSeen[currentChar] = r;
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}