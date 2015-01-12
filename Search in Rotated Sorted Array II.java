public class Solution {
    public boolean search(int[] A, int target) {
        return sr(A, target, 0, A.length - 1);
    }
    public boolean sr(int[] A, int target, int left, int right) {
        if(left > right) return false;
        int mid = (left + right) >> 1;
        if(A[mid] == target) return true;
        if(target < A[mid] && A[mid] < A[left]) return sr(A, target, left, mid - 1);
        if(A[mid] == A[left] && A[left] == A[right]) return sr(A,target, left, mid - 1) || sr(A, target, mid + 1, right);
        if(A[mid] == A[left] && A[mid] > A[right]) return sr(A, target, mid + 1, right);
        if(target < A[mid] && A[mid] > A[left]) return bs(A, target, left, mid - 1) || sr(A, target, mid + 1, right);
        if(target > A[mid] && A[mid] < A[left]) return bs(A, target, mid + 1, right) || sr(A, target, left, mid - 1);
        else return sr(A, target, mid + 1, right);
    }
    public boolean bs(int[] A, int target, int start, int end) {
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(A[mid] == target) return true;
            if(A[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
}
