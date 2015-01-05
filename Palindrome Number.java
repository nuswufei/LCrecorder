public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        long digitProbe = 10;
        int len = 1;
        while(digitProbe <= x) {
            digitProbe *= 10;
            ++len;
        }
        for(int i = 1; i <= len >> 1; ++i) {
            if(getDigit(x, i) != getDigit(x, len + 1 - i)) return false;
        }
        return true;
    }
    private int getDigit(int x, int d) {
        return (x / (int) Math.pow(10, d - 1)) % 10;
    }
}
