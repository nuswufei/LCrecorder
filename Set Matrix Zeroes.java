public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        boolean colZero = false;
        boolean rowZero = false;
        for(int i = 0; i < matrix.length; ++i) {
            if(matrix[i][0] == 0) colZero = true;
        }
        for(int j = 0; j < matrix[0].length; ++j) {
            if(matrix[0][j] == 0) rowZero = true;
        }
        for(int i = 1 ; i < matrix.length; ++i) {
            for(int j = 1; j < matrix[0].length; ++j) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; ++i) {
            if(matrix[i][0] == 0) {
                setRowNZero(matrix, i);
            }
        }
        for(int j = 1; j < matrix[0].length; ++j) {
            if(matrix[0][j] == 0) {
                setColNZero(matrix, j);
            }
        }
        if(colZero) setColNZero(matrix, 0);
        if(rowZero) setRowNZero(matrix, 0);
    }
    private void setColNZero(int[][] matrix, int n) {
        for(int i = 0; i < matrix.length; ++i) matrix[i][n] = 0;
    }
    private void setRowNZero(int[][] matrix, int n) {
        for(int j = 0; j < matrix[0].length; ++j) matrix[n][j] = 0;
    }
}
