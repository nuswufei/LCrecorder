public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        int comLength = strs[0].length();
        for(int i = 1; i < strs.length; ++i) {
            comLength = commonStr(strs[0], comLength, strs[i]);
        }
        return strs[0].substring(0, comLength);
    }
    private int commonStr(String s1, int comLength, String s2) {
        int end = 0;
        while(end < comLength && end < s2.length() && s1.charAt(end) == s2.charAt(end)) ++end;
        return end;
    }
}
