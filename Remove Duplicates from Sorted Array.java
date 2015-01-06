public class Solution {
    public int removeDuplicates(int[] A) {
        int offset = 0;
        int finalLength = A.length;
        for(int i = 1; i < finalLength; ) {
            A[i] = A[i + offset];
            if(A[i] == A[i - 1]) {
                ++offset;
                --finalLength;
            } else {++i;}
        }
        return finalLength;
    }
}
