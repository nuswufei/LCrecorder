public class Solution {
    public boolean isPalindrome(String s) {
        int left  = 0;
        int right = s.length() - 1;
        while(left < right) {
            if(!isValid(s.charAt(left))) {
                ++left;
                continue;
            }
            if(!isValid(s.charAt(right))) {
                --right;
                continue;
            }
            if(Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))) return false;
        }
        return true;
    }
    boolean isValid(char ch) {
        return Character.isLetter(ch) || Character.isDigit(ch);
    }
}
