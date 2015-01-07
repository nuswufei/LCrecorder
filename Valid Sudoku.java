public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> dic = new HashSet<Character>();
        for(int i = 1; i < 10; ++i) dic.add((i + "").charAt(0));
        for(int i = 0; i < board.length; ++i) {
            HashSet<Character> dicCopy = new HashSet<Character>(dic);
            for(int j = 0; j < board[0].length; ++j) {
                if(board[i][j] != '.') {
                    if(dicCopy.contains(board[i][j])) dicCopy.remove(board[i][j]);
                    else return false;
                }
            }
        }
        for(int j = 0; j < board[0].length; ++j) {
            HashSet<Character> dicCopy = new HashSet<Character>(dic);
            for(int i = 0; i < board.length; ++i) {
                if(board[i][j] != '.') {
                    if(dicCopy.contains(board[i][j])) dicCopy.remove(board[i][j]);
                    else return false;
                }
            }
        }
        for(int offseti = 0; offseti < 9; offseti += 3) {
        	for(int offsetj = 0; offsetj < 9; offsetj += 3) {
        		HashSet<Character> dicCopy = new HashSet<Character>(dic);
                for(int i = offseti; i < offseti + 3; ++i) {
                    for(int j = offsetj; j < offsetj + 3; ++j) {
                        if(board[i][j] != '.') {
                            if(dicCopy.contains(board[i][j])) dicCopy.remove(board[i][j]);
                            else return false;
                        }
                    }
                }
        	}
        }
        return true;
    }
}
