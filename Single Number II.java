public class Solution {
    public int singleNumber(int[] A) {
        int result = 0;
        for(int i = 0; i < 32; ++i) {
            int sum = 0;
            for(int num : A) {
                sum = (sum + ((num >> i) & 1)) % 3;
            }
            result += sum << i;
        }
        return result;
    }
}
