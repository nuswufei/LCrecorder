public class Solution {
    public int titleToNumber(String s) {
        int digit = 1;
        int result = 0;
        for(int i = s.length() - 1; i >= 0; --i) {
            result += (int)(s.charAt(i) - 'A' + 1) * digit;
            digit *= 26;
        }
        return result;
    }
}
