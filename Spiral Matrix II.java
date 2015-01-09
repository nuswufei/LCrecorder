public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if((n & 1) == 1) result[n >> 1][ n >> 1] = n * n;
        int loopStart = 1;
        for(int i = 0; i < n >> 1; ++i) {
            loopStart = fill(result, n, i, loopStart);
        }
        return result;
    }
    private int fill(int[][] result, int n, int loop, int start) {
        for(int i = loop; i < n - 1 - loop; ++i) result[loop][i] = start++;
        for(int i = loop; i < n - 1 - loop; ++i) result[i][n - 1 - loop] = start++;
        for(int i = n - 1 - loop; i > loop; --i) result[n - 1 - loop][i] = start++;
        for(int i = n - 1 - loop; i > loop; --i) result[i][loop] = start++;
        return start;
    }
}
