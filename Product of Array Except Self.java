public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int mul = 1;
        for(int i = 1; i< nums.length; ++i) {
            mul *= nums[i - 1];
            res[i] = mul;
        }
        mul = 1;
        for(int i = nums.length - 1; i > 0; --i) {
            res[i] *= mul;
            mul *= nums[i];
        }
        res[0] = mul;
        return res;
    }
}
