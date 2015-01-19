public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int start = 0;
        int max = 0;
        HashMap<Character, Integer> dic = new HashMap<Character, Integer>();
        for(int end = 0; end <= s.length(); ++end) {
            if(end == s.length()) return Math.max(max, end - start);
            if(dic.size() < 2 || dic.containsKey(s.charAt(end))) dic.put(s.charAt(end), end);
            else {
                max = Math.max(max, end - start);
                int del = s.length();
                Character delKey = 'a';
                for(Character k : dic.keySet()) {
                    if(dic.get(k) < del) {
                        del = dic.get(k);
                        delKey = k;
                    }
                }
                start = del + 1;
                dic.remove(delKey);
                dic.put(s.charAt(end), end);
            }
        }
        return max;
    }
}
