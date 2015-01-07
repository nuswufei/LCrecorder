public class Solution {
    public void solveSudoku(char[][] board) {
        List<Integer> empty = new ArrayList<Integer>();
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                if(board[i][j] == '.') empty.add(i * board[0].length + j);
            }
        }
        int size = empty.size();
        dfsSearch(board, empty, size, 0);
    }
    private boolean dfsSearch(char[][] board, List<Integer> empty, int size, int cur) {
        if(size == cur) return true;
        int row = empty.get(cur) / board[0].length;
        int col = empty.get(cur) % board[0].length;
        for(int i = 1; i < 10; ++i) {
            board[row][col] = (char)('0' + i);
            if(isValid(board, row, col)) {
                if(dfsSearch(board, empty, size, cur + 1)) return true;
            }
        }
        board[row][col] = '.';
        return false;
    }
    private boolean isValid(char[][] board, int row, int col) {
        for(int i = 0; i < board.length; ++i) {
            if(i != row && board[i][col] == board[row][col]) return false;
        }
        for(int j = 0; j< board[0].length; ++j) {
            if(j != col && board[row][j] == board[row][col]) return false;
        }
        for(int i = row / 3 * 3; i < row / 3 * 3 + 3; ++i) {
            for(int j = col / 3 * 3; j < col / 3 * 3 + 3; ++j) {
                if(!(i == row && j == col) && board[i][j] == board[row][col]) return false;
            }
        }
        return true;
    }
}
