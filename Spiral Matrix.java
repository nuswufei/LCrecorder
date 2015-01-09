public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix[0].length == 0) return result;
        int m = matrix.length;
        int n = matrix[0].length;
        int loop = Math.min(m, n) >> 1;
        for(int i = 0; i < loop; ++i) {
            addLoop(matrix, result, i);
        }
        if(m <= n && (m & 1) == 1) {
            for(int i = loop; i < n - loop; ++i) result.add(matrix[m / 2][i]);
        }
        else if(n < m && (n & 1) == 1) {
            for(int i = loop; i < m - loop; ++i) result.add(matrix[i][n / 2]);
        }
        return result;
    }
    private void addLoop(int[][] matrix, List<Integer> result, int loop) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int j = loop; j < n - loop - 1; ++j) result.add(matrix[loop][j]);
        for(int i = loop; i < m - loop - 1; ++i) result.add(matrix[i][n - loop - 1]);
        for(int j = n - loop - 1; j > loop; --j) result.add(matrix[m - loop - 1][j]);
        for(int i = m - loop - 1; i > loop; --i) result.add(matrix[i][loop]);
    }
}
