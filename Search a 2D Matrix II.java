public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int left = 0;
        int right = matrix[0].length - 1;
        while(left < matrix.length && right >= 0) {
            if(matrix[left][right] == target) return true;
            if(matrix[left][right] > target) --right;
            else ++left;
        }
        return false;
    }
}
