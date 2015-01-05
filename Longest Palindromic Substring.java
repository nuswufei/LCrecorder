public class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0) return s;
        Integer[] pal = new Integer[s.length() * 2 + 1];
        for(int i = 0; i < pal.length; ++i) {
            if(pal[i] == null) fill(i, pal, s);
        }
        int len = 0;
        int mid = 0;
        for(int i = 0; i < pal.length; ++i) {
            if(pal[i] > len) {
                len = pal[i];
                mid = i;
            }
        }
        return s.substring((mid - len) >> 1, ((mid + len - 1) >> 1) + 1);
    }
    private void fill(int mid, Integer[] pal, String s) {
        int len = 0;
        while(mid - len >= 0 && mid + len < pal.length && equals(s, mid - len, mid + len)) ++len;
        --len;
        pal[mid] = len;
        for(int i = 1; i <= len; ++i) {
            if(pal[mid - i] < len - i) pal[mid + i] = pal[mid - i];
        }
    }
    private boolean equals(String s, int i1, int i2) {
        if((i1 & 1) == 0) return true;
        if(s.charAt(i1 >> 1) == s.charAt(i2 >> 1)) return true;
        return false;
    }
}
