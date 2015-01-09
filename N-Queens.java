public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();
        char[] board = new char[n * n];
        for(int i = 0; i < board.length; ++i) board[i] = '.';
        HashSet<Integer> leftIndex = new HashSet<Integer>();
        for(int i = 0; i < n; ++i) leftIndex.add(i);
        dfs(result, board, 0, leftIndex, n);
        return result;
    }
    private void dfs(List<String[]> result, char[] board, int depth, HashSet<Integer> leftIndex, int n) {
        if(leftIndex.isEmpty()) result.add(getString(board, n));
        for(Integer index : leftIndex) {
            if(valid(index, depth, board, n)) {
                char[] boardCopy = board.clone();
                boardCopy[depth * n + index] = 'Q';
                HashSet<Integer> leftIndexCopy = new HashSet<Integer>(leftIndex);
                leftIndexCopy.remove(index);
                dfs(result, boardCopy, depth + 1, leftIndexCopy, n);
            }
        }
    }
    private String[] getString(char[] board, int n) {
        String[] result = new String[n];
        for(int i = 0; i < n; ++i) result[i] = new String(Arrays.copyOfRange(board, i * n, i * n + n));
        return result;
    }
    private boolean valid(int index, int depth, char[] board, int n) {
        for(int i = 0; i < depth; ++i) {
            if(board[i * n + index] == 'Q') return false;
        }
        for(int i = Math.max(index - depth, 0); i < Math.min(n, index + depth + 1); ++i) {
            if(board[(depth - Math.abs(index - i)) * n + i] == 'Q') return false;
        }
        return true;
    }
}
