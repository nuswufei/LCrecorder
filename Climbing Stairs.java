public class Solution {
    public int climbStairs(int n) {
        if(++n < 3) return 1;
        int first = 1;
        int second = 2;
        for(int i  = 3; i < n; ++i) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }
}
