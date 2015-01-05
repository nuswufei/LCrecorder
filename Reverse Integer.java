public class Solution {
    public int reverse(int x) {
        long result = 0;
        long val = Math.abs(x);
        while(val != 0) {
            result *= 10;
            result += val % 10;
            val /= 10;
        }
        if(x < 0) result *= -1;
        return (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) ? 0 : (int) result;
    }
}
