public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dpT = new int[m][n];
        dpT[0][0] = grid[0][0];
        for(int i = 1; i < m; ++i) dpT[i][0] = dpT[i - 1][0] + grid[i][0];
        for(int i = 1; i < n; ++i) dpT[0][i] = dpT[0][i - 1] + grid[0][i];
        for(int i  = 1; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                dpT[i][j] = Math.min(dpT[i - 1][j], dpT[i][j - 1]) + grid[i][j];
            }
        }
        return dpT[m - 1][n - 1];
    }
}
