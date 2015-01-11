public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return true;
        if(board.length == 0 || board[0].length == 0) return false;
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                if(dfs(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int cur, int m, int n) {
        if(cur == word.length()) return true;
        if(m < 0 || n < 0 || m >= board.length || n >= board[0].length || board[m][n] != word.charAt(cur)) return false;
        char mn = board[m][n];
        board[m][n] = '.';
        if(dfs(board, word, cur + 1, m + 1, n)) return true;
        if(dfs(board, word, cur + 1, m - 1, n)) return true;
        if(dfs(board, word, cur + 1, m, n + 1)) return true;
        if(dfs(board, word, cur + 1, m, n - 1)) return true;
        board[m][n] = mn;
        return false;
    }
}
