public class Solution {
    public int uniquePaths(int m, int n) {
        int[] dpTable = new int[m * n];
        for(int i = 0; i < n; ++i) dpTable[getIndex(0, i, n)] = 1;
        for(int i = 0; i < m; ++i) dpTable[getIndex(i, 0, n)] = 1;
        for(int i = 1; i < n; ++i) {
            for(int j = 1; j < m; ++j) {
                dpTable[getIndex(j, i, n)] = dpTable[getIndex(j - 1, i, n)] + dpTable[getIndex(j, i - 1, n)];
            }
        }
        return dpTable[getIndex(m - 1, n - 1, n)];
    }
    private int getIndex(int row, int col, int n) {return row * n + col;}
}
