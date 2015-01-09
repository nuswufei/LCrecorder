public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dpTable = new int[m][n];
        dpTable[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for(int i = 1; i < m; ++i) dpTable[i][0] = obstacleGrid[i][0] == 1 ? 0 : dpTable[i - 1][0];
        for(int i = 1; i < n; ++i) dpTable[0][i] = obstacleGrid[0][i] == 1 ? 0 : dpTable[0][i - 1];
        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                dpTable[i][j] = obstacleGrid[i][j] == 1? 0 : dpTable[i - 1][j] + dpTable[i][j - 1];
            }
        }
        return dpTable[m - 1][n - 1];
    }
}
