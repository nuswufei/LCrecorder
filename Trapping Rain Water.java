public class Solution {
    public int trap(int[] A) {
        int result = 0;
        int max = 0;
        int maxIndex = -1;
        for(int i = 0; i < A.length; ++i) {
            if(A[i] > max) {
                max = A[i];
                maxIndex = i;
            }
        }
        int leftMax = 0;
        for(int i = 0; i < maxIndex; ++i) {
            leftMax = Math.max(leftMax, A[i]);
            result += leftMax - A[i];
        }
        int rightMax = 0;
        for(int i = A.length - 1; i > maxIndex; --i) {
            rightMax = Math.max(rightMax, A[i]);
            result += rightMax - A[i];
        }
        return result;
    }
}
