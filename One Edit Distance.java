public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.length() == t.length()) {
            int dif = 0;
            for(int i = 0; i < s.length(); ++i) {
                if(s.charAt(i) != t.charAt(i)) ++dif;
            }
            return dif == 1;
        }
        if(s.length() > t.length()) return difLengthJudger(t, s);
        else return difLengthJudger(s, t);
    }
    boolean difLengthJudger(String s, String l) {
        if(l.length() - s.length() != 1) return false;
        int i = 0;
        for(; i < s.length(); ++i) {
            if(s.charAt(i) != l.charAt(i)) break;
        }
        if(i == s.length()) return true;
        return s.substring(i, s.length()).equals(l.substring(i + 1, l.length()));
    }
}
