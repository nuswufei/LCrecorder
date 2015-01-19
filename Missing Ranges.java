public class Solution {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        int i = 0;
        int start = lower;
        while (i < A.length && A[i] < lower) ++i;
        List<String> result = new ArrayList<String>();
        for(; i <= A.length; ++i) {
            int cur = i == A.length ? upper : Math.min(upper, A[i] - 1);
            if(cur == start) {
                result.add(start + "");
            }
            else if(cur > start) {
                result.add(start + "->" + cur);
            }
            if(cur >= upper) break;
            start = cur + 2;
        }
        return result;
    }
}
