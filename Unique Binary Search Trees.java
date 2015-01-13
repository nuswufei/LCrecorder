public class Solution {
    public int numTrees(int n) {
        int[] dpt = new int[n + 1];
        dpt[0] = 1;
        dpt[1] = 1;
        for(int i = 2; i < dpt.length; ++i) {
            for(int j = 0; j < i; ++j) {
                dpt[i] += dpt[j] * dpt[i - j - 1];
            }
        }
        return dpt[n];
    }
}
