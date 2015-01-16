public class Solution {
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        Stack<int[]> stk = new Stack<int[]>();
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                if((i == 0 || j ==0 || i ==board.length - 1 || j == board[0].length - 1) && board[i][j] == 'O') {
                    stk.push(new int[]{i, j});
                }
            }
        }
        while(stk.size() != 0) {
            int[] cur = stk.pop();
            int i = cur[0];
            int j = cur[1];
            if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) continue;
            if(board[i][j] != 'O') continue;
            board[i][j] = '.';
            stk.push(new int[]{i - 1, j});
            stk.push(new int[]{i + 1, j});
            stk.push(new int[]{i, j - 1});
            stk.push(new int[]{i, j + 1});
        }
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '.') board[i][j] = 'O';
            }
        }
    }
}
