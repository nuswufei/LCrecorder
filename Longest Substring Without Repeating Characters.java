public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<Character, Integer>();
        int result = 0;
        int windowStart = 0;
        int windowEnd = 0;
        while(windowEnd < s.length()) {
            if(window.containsKey(s.charAt(windowEnd)) && window.get(s.charAt(windowEnd)) >= windowStart) {
                result = Math.max(result, windowEnd - windowStart);
                windowStart = window.get(s.charAt(windowEnd)) + 1;
            }
            window.put(s.charAt(windowEnd), windowEnd);
            ++windowEnd;
        }
        result = Math.max(result, windowEnd - windowStart);
        return result;
    }
}
