public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) return false;
        Boolean[][] dpt = new Boolean[s1.length() + 1][s2.length() + 1];
        dpt[s1.length()][s2.length()] = true;
        int up;
        for(up = 1; up <= s2.length(); ++up) {
            if(s2.charAt(s2.length() - up) == s3.charAt(s3.length() - up)) dpt[s1.length()][s2.length()-up] = true;
            else break;
        }
        while(up <= s2.length()) dpt[s1.length()][s2.length() - up++] = false;
        for(up = 1; up <= s1.length(); ++up) {
            if(s1.charAt(s1.length() - up) == s3.charAt(s3.length() - up)) dpt[s1.length() - up][s2.length()] = true;
            else break;
        }
        while(up <= s1.length()) dpt[s1.length() - up++][s2.length()] = false;
        for(int s1start = s1.length() - 1; s1start >= 0; --s1start) {
            for(int s2start = s2.length() - 1; s2start >= 0; --s2start) {
                if(s1.charAt(s1start) == s3.charAt(s1start + s2start) && dpt[s1start + 1][s2start]) dpt[s1start][s2start] = true;
                else if(s2.charAt(s2start) == s3.charAt(s1start + s2start) && dpt[s1start][s2start + 1]) dpt[s1start][s2start] = true;
                else dpt[s1start][s2start] = false;
            }
        }
        return dpt[0][0];
    }
}
