public class Solution {
    public int[] searchRange(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        int lb = -1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(isLB(A, mid, target)) {
                lb = mid;
                break;
            }
            if(A[mid] >= target) end = mid - 1;
            else start = mid + 1;
        }
        if(lb == -1) return new int[] {-1, -1};
        int ub = -1;
        start = 0;
        end = A.length - 1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(isUB(A, mid, target)) {
                ub = mid;
                break;
            }
            if(A[mid] <= target) start = mid + 1;
            else end = mid - 1;
        }
        return new int[] {lb, ub};
    }
    private boolean isLB(int[] A, int index, int target) {
        return A[index] == target && (index == 0 || A[index - 1] < target);
    }
    private boolean isUB(int[] A, int index, int target) {
        return A[index] == target && (index == A.length - 1 || A[index + 1] > target);
    }
}
