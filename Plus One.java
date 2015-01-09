public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int n = digits.length - 1;
        do {
            int temp = (digits[n] + carry) / 10;
            digits[n] = (digits[n--] + carry) % 10;
            carry = temp;
        } while(carry != 0 && n >=0);
        if(!(carry != 0 && n < 0)) return digits;
        else {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
    }
}
