class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for(String s : strs){
            encoded.append(s.length()).append('#').append(s);        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;

        while(i < str.length()){
            int delimiterPos = str.indexOf("#", i);
            int len = Integer.parseInt(str.substring(i, delimiterPos));

            int startIndex = delimiterPos + 1;
            int endIndex = startIndex + len;
            ans.add(str.substring(startIndex, endIndex));

            i = endIndex;
        }

        return ans;
    }
}
