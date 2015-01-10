public class Solution {
    public String addBinary(String a, String b) {
        int[] nums = new int[Math.max(a.length(), b.length())];
        int carry = 0;
        for(int i = 0; i < Math.max(a.length(), b.length()); ++i) {
            int digit = getNum(a, i) + getNum(b, i) + carry;
            nums[nums.length - i - 1] = digit % 2;
            carry = digit / 2;
        }
        StringBuilder sb = new StringBuilder();
        if(carry != 0) sb.append(1 + "");
        for(int i : nums) sb.append(i + "");
        return sb.toString();
    }
    private int getNum(String s, int i) {
        if(i >= s.length()) return 0;
        else return Integer.parseInt(s.charAt(s.length() - i - 1) + "");
    }
}
