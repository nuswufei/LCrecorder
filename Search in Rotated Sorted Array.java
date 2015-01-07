public class Solution {
    public int search(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(A[mid] == target) return mid;
            if((A[mid] >= A[start] && target > A[mid]) || (target < A[start] && !(A[mid] < A[start] && target < A[mid]))) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
