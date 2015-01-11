public class Solution {
    public int removeDuplicates(int[] A) {
        int left = 2;
        for(int i = 2; i < A.length; ++i) {
            A[left] = A[i];
            if(A[left] != A[left - 1] || A[left] != A[left - 2]) ++left;
        }
        return Math.min(A.length, left);
    }
}
