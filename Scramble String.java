public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        Boolean[][][] dpt = new Boolean[s1.length() + 1][s1.length()][s1.length()];
        for(int s1start = 0; s1start < s1.length(); ++s1start) {
            for(int s2start = 0; s2start < s2.length(); ++s2start) {
                dpt[1][s1start][s2start] = s1.charAt(s1start) == s2.charAt(s2start);
            }
        }
        for(int length = 2; length < s1.length() + 1; ++length) {
            for(int s1start = 0; s1start <= s1.length() - length; ++s1start) {
                for(int s2start = 0; s2start <= s2.length() - length; ++s2start) {
                    boolean result = false;
                    for(int i = 1; i < length; ++i) {
                        if((dpt[i][s1start][s2start] && dpt[length - i][s1start + i][s2start +i])
                        || (dpt[i][s1start][s2start + length - i] && dpt[length - i][s1start + i][s2start])) {
                            result = true;
                            break;
                        }
                    }
                    dpt[length][s1start][s2start] = result;
                }
            }
        }
        return dpt[s1.length()][0][0];
    }
}
