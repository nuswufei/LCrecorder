public class Solution {
    public int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE;
        int segSum = 0;
        for(int i = 0; i < A.length; ++i) {
            segSum += A[i];
            max = Math.max(max, segSum);
            segSum = segSum >= 0 ? segSum : 0;
        }
        return max;
    }
}
