public class Solution {
    public int jump(int[] A) {
        if(A.length == 1) return 0;
        int step = 0;
        int index = 0;
        while(A[index] + index < A.length - 1) {
            int nextIndex = index;
            int furthest = 0;
            for(int i = 1; i <= A[index]; ++i) {
                if(A[index + i] + i >= furthest) {
                    furthest = A[index + i] + i;
                    nextIndex = index + i;
                }
            }
            index = nextIndex;
            ++step;
        }
        return ++step;
    }
}
