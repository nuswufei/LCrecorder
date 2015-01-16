public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        Boolean[] dpt = new Boolean[s.length() + 1];
        dpt[0] = true;
        for(int end = 1; end <= s.length(); ++end) {
            for(int start = 0; start < end; ++ start) {
                if(dict.contains(s.substring(start, end)) && dpt[start]) {
                    dpt[end] = true;
                    break;
                }
                dpt[end] = false;
            }
        }
        return dpt[s.length()];
    }
}
