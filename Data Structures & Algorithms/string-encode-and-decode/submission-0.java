class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            // Append length, then '#', then the actual string
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < str.length()) {
            int delimiterPos = str.indexOf('#', i);            
            int length = Integer.parseInt(str.substring(i, delimiterPos));
            
            int startOfStr = delimiterPos + 1;
            int endOfStr = startOfStr + length;
            
            result.add(str.substring(startOfStr, endOfStr));
            
            i = endOfStr;
        }
        
        return result;
    }
}