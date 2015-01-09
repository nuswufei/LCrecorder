public class Solution {
    public boolean canJump(int[] A) {
        int index = 0;
        while(index < A.length) {
            if(A[index] == 0 && index != A.length - 1) return false;
            if(index + A[index] >= A.length - 1) return true;
            int furthest = 0;
            int nextstep = 0;
            for(int i = 1; i <= A[index]; ++i) {
                if(i + A[index + i] >= furthest) {
                    furthest = i + A[index + i];
                    nextstep = i;
                }
            }
            index += nextstep;
        }
        return true;
    }
}
