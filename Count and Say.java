public class Solution {
    public String countAndSay(int n) {
    	String nStr = "1";
    	for(int i = 1; i < n; ++i) {
    		StringBuilder result = new StringBuilder();
            int count = 0;
            char num;
            for(int j = 0; j < nStr.length(); ++j) {
                ++count;
                num = nStr.charAt(j);
                if(j + 1 == nStr.length() || nStr.charAt(j) != nStr.charAt(j + 1)) {
                    result.append(count + "");
                    result.append(num + "");
                    count = 0;
                }
            }
            nStr = result.toString();
    	}
    	return nStr;
    }
}
