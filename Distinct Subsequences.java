public class Solution {
    public int numDistinct(String S, String T) {
        if(S.length() < T.length()) return 0;
        if(T.length() == 0) return 0;
        int[][] dpt = new int[T.length() + 1][S.length() + 1];
        for(int i  = 0; i <= S.length(); ++i) dpt[0][i] = 1;
        for(int i = 1; i <= T.length(); ++i) {
            for(int j = i; j <= S.length() - T.length() + i; ++j) {
                if(S.charAt(j - 1) == T.charAt(i - 1)) dpt[i][j] = dpt[i - 1][j - 1] + dpt[i][j - 1];
                else dpt[i][j] = dpt[i][j - 1];
            }
        }
        return dpt[T.length()][S.length()];
    }
}
