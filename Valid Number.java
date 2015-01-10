public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if(isDouble(s)) return true;
        int eIndex = s.indexOf("e");
        if(eIndex == -1) return false;
        if(eIndex > 0 && isDouble(s.substring(0, eIndex)) && eIndex < s.length() && isNum(s.substring(eIndex + 1))) return true;
        return false;
    }
    private boolean isDouble(String s) {
        if(isNum(s)) return true;
        int dotIndex = s.indexOf(".");
        if(dotIndex != -1 && s.length() > 1 && (dotIndex == 0 || isNum(s.substring(0, dotIndex))) && (dotIndex == s.length() - 1 || ispureNum(s.substring(dotIndex + 1)))) return true;
        if(dotIndex == 1 && (s.charAt(0) =='+' || s.charAt(0) =='-') && ispureNum(s.substring(dotIndex + 1))) return true;
        return false;
    }
    private boolean isNum(String s) {
        if(ispureNum(s)) return true;
        if(s.length() > 1 && (s.charAt(0) =='+' || s.charAt(0) =='-')) return ispureNum(s.substring(1));
        return false;
    }
    private boolean ispureNum(String s) {
        if(s.length() == 0) return false;
        for(int i = 0; i < s.length(); ++i) {
            if(!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
}
