public class Solution {
    public boolean isMatch(String s, String p) {
        int sbackup = -1;
        int pbackup = -1;
        int si = 0;
        int pi = 0;
        while(si < s.length()) {
            if(pi < p.length() && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?')) {
                ++si;
                ++pi;
            }
            else if(pi < p.length() && p.charAt(pi) == '*') {
                sbackup = si;
                if(++pi >= p.length()) return true;
                pbackup = pi;
            }
            else {
                if(pbackup == -1) return false;
                si = ++sbackup;
                pi = pbackup;
            }
        }
        while(pi < p.length() && p.charAt(pi) == '*') ++pi;
        return si >= s.length() && pi >= p.length();
    }
}
