public class Solution {
    public int majorityElement(int[] num) {
        int n = 0;
        int count = 0;
        for(int i : num) {
            if(count == 0) {
                n = i;
                count = 1;
            }
            else if(i == n) ++count;
            else --count;
        }
        return n;
    }
}
