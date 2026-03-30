class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0; int r = 0;
        int n = s.length();
        HashMap<Character, Integer> freq = new HashMap<>();
        int maxLen = 0;


        for(r=0; r<=n-1; r++){
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);

            while(freq.get(s.charAt(r)) > 1){
                freq.put(s.charAt(l), freq.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }

            if(r >= l){
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }
    return maxLen;
    }
}
