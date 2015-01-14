public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
        int n = triangle.get(triangle.size() - 1).size();
        int[][] dpt = new int[n][n];
        for(int i = 0; i < dpt.length; ++i) dpt[dpt.length - 1][i] = triangle.get(triangle.size() - 1).get(i);
        for(int i = dpt.length - 2; i >=0; --i) {
            for(int j = 0; j < i + 1; ++j) {
                dpt[i][j] = triangle.get(i).get(j) + Math.min(dpt[i + 1][j], dpt[i + 1][j + 1]);
            }
        }
        return dpt[0][0];
    }
}
