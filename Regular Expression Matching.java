public class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dpTable = new Boolean[s.length()][p.length()];
  	  return isM(s, 0, p, 0, dpTable);
    }
    private boolean isM(String s, int sstart, String p, int pstart, Boolean[][] dpTable) {
        if(sstart >= s.length()) {
            while(pstart < p.length()) {
            	if(p.charAt(pstart) == '*' || (pstart + 1 < p.length() && p.charAt(pstart + 1) == '*')) ++pstart;
            	else break;
            }
            return pstart >= p.length();
        }
        if(pstart >= p.length()) return false;
        if(dpTable[sstart][pstart] != null) return dpTable[sstart][pstart];
        if(pstart + 1 >= p.length() || p.charAt(pstart + 1) != '*') {
            dpTable[sstart][pstart] = equals(s.charAt(sstart), p.charAt(pstart)) ? isM(s, sstart + 1, p, pstart + 1, dpTable) : false;
            return dpTable[sstart][pstart];
        } else {
            boolean result = isM(s, sstart, p, pstart + 2, dpTable);
            int i = 1;
            while(!result && sstart + i <= s.length() && equals(s.charAt(sstart + i - 1), p.charAt(pstart))) {
                result = isM(s, sstart + i, p, pstart + 2, dpTable);
                ++i;
            }
            dpTable[sstart][pstart] = result;
            return result;
        }
    }
    private boolean equals(char schar, char pchar) {
        return schar == pchar || pchar == '.';
    }
}
