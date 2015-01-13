public class Solution {
	   public int numDecodings(String s) {
	       if(s.length() == 0) return 0;
	       int[] dpt = new int[s.length() + 1];
	       dpt[0] = 1;
	       dpt[1] = s.charAt(0) == '0' ? 0 : 1;
	       for(int i = 2; i <= s.length(); ++i) {
	           int result = 0;
	           if(s.charAt(i - 1) != '0') result += dpt[i - 1];
	           int lastTwo = Integer.parseInt(s.substring(i - 2, i));
	           if(lastTwo <= 26 && lastTwo > 9) result += dpt[i - 2];
	           dpt[i] = result;
	       }
	       return dpt[s.length()];
	   }
}
