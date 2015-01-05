public class Solution {
    public int atoi(String str) {
        String noSpaceStr = str.trim();
        if(noSpaceStr.length() == 0) return 0;
        int sign = 1;
        if(noSpaceStr.charAt(0) == '-') sign = -1;
        long num = getNum(noSpaceStr);
        if(num > Integer.MAX_VALUE) return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        else return (int)(num * sign);
    }
    private long getNum(String s) {
        int i = 0;
        if(s.charAt(0) == '+' || s.charAt(0) == '-') ++i;
        long result = 0;
        while(i < s.length() && Character.isDigit(s.charAt(i))) {
            result *= 10;
            result += Integer.parseInt(s.charAt(i++) +"");
            if(result > Integer.MAX_VALUE) break;
        }
        return result;
    }
}
