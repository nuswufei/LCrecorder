public class Solution {
    public int divide(int dividend, int divisor) {
        boolean negative = dividend > 0 ^ divisor > 0;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        long result = 0;
        for(int digit = 32; digit >= 0; --digit) {
            if(ldividend >> digit >= ldivisor) {
                result += ((long)1 << digit);
                ldividend -= (ldivisor << digit);
                System.out.print(result);
            }
        }
        if(result > Integer.MAX_VALUE && !negative) return Integer.MAX_VALUE;
        return negative? -(int)result : (int)result;
    }
}
