public class Solution {
	public String multiply(String num1, String num2) {
	    int[] result = new int[num1.length() + num2.length()];
	    for(int i  = 0; i < num1.length(); ++i) {
	        for(int j = 0; j < num2.length(); ++j) {
	            int stepResult = (num1.charAt(num1.length() - 1 - i) - '0') * (num2.charAt(num2.length() - 1 - j) - '0');
	            int offset = result.length - 1 - i -j;
	            int carry = 0;
	            result[offset] += stepResult;
	            do {
	            	int temp = result[offset] + carry;
	                result[offset] = temp % 10;
	                carry = temp / 10;
	                --offset;
	               
	            } while(carry != 0);
	        }
	    }
	    int i = 0;
	    while(result[i] == 0 && i < result.length - 1) ++i;
	    StringBuilder sb = new StringBuilder();
	    for(;i<result.length; ++i) sb.append(result[i] + "");
	    return sb.toString();
	}
}
