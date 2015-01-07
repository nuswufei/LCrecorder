public class Solution {
    public int searchInsert(int[] A, int target) {
        int start = 0; 
        int end = A.length - 1;
        int result = A.length;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(isPosition(A, mid, target)) {
                result = mid;
                break;
            }
            if(A[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return result;
    }
    private boolean isPosition(int[] A, int index, int target) {
        return A[index] == target || (A[index] > target && (index == 0 || A[index - 1] < target));
    }
}
