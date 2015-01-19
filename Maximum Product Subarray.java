public class Solution {
    public int maxProduct(int[] A) {
        if(A.length == 1) return A[0];
        int result = 0;
        int max = 0;
        int min = 0;
        int firstNeg = 0;
        int firstNegIndex = 0;
        for(int i = 0; i < A.length + 1; ++i) {
            if(i == A.length || (i != A.length && A[i] == 0)) {
                result = Math.max(result, max);
                if(firstNeg != 0  && firstNegIndex != i - 1) result  = Math.max(result, min / firstNeg);
                max = 0;
                min = 0;
                firstNeg = 0;
            }
            else{
                if(max == 0) {
                    max = A[i];
                    min = A[i];
                }
                else {
                    int curMax = max * A[i];
                    int curMin = min * A[i];
                    max = Math.max(curMax, curMin);
                    min = Math.min(curMax, curMin);
                }
                if(min < 0 && firstNeg == 0) {
                    firstNeg = min;
                    firstNegIndex = i;
                }
                result = Math.max(max, result);
                if(firstNeg != 0  && firstNegIndex != i) result  = Math.max(result, min / firstNeg);
            }
        }
        return result;
    }
}
