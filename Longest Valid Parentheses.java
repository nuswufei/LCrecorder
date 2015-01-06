public class Solution {
    public int longestValidParentheses(String s) {
        int depth = 0;
        int start = 0;
        int result = 0;
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '(') ++depth;
            else if (depth == 0) start = i + 1;
            else if (depth == 1) {
                result = Math.max(i - start + 1, result);
                depth = 0;
            }
            else --depth;
        }
        depth = 0;
        start = s.length() - 1;
        for(int i = s.length() - 1; i >= 0; --i) {
            if(s.charAt(i) == ')') ++depth;
            else if(depth == 0) start = i - 1;
            else if(depth == 1) {
                result = Math.max(start - i + 1, result);
                depth = 0;
            }
            else --depth;
        }
        return result;
    }
}
