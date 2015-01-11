public class Solution {
    public void sortColors(int[] A) {
        int zeroPoint = 0;
        int twoPoint = A.length - 1;
        for(int i = 0; i <= twoPoint;) {
            if(A[i] == 0) swap(A, zeroPoint++, i);
            if(A[i] == 2) swap(A, twoPoint--, i);
            else ++i;
        }
    }
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
