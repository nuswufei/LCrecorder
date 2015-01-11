public class Solution {
    public String minWindow(String S, String T) {
        if(S.length() < T.length() || S.length() == 0) return "";
        Map<Character, Integer> window = new HashMap<Character, Integer>();
        for(int i = 0; i < T.length(); ++i) {
            if(window.containsKey(T.charAt(i))) window.put(T.charAt(i), window.get(T.charAt(i)) + 1);
            else window.put(T.charAt(i), 1);
        }
        int count = 0;
        int i = 0;
        while(i < S.length() && count < T.length()) {
            if(window.containsKey(S.charAt(i))) {
                window.put(S.charAt(i), window.get(S.charAt(i)) - 1);
                if(window.get(S.charAt(i)) >= 0) ++count;
            }
            ++i;
        }
        if(count < T.length()) return "";
        int left = moveLeft(window, 0, S);
        int minleft = left;
        int minright = i;
        int minLength = minright - minleft;
        for(; i < S.length(); ++i) {
            if(window.containsKey(S.charAt(i))) {
                window.put(S.charAt(i), window.get(S.charAt(i)) - 1);
                left = moveLeft(window, left, S);
                if(i - left + 1 < minLength) {
                    minleft = left;
                    minright = i + 1;
                    minLength = minright - minleft;
                }
            }
        }
        return S.substring(minleft, minright);
    }
    private int moveLeft(Map<Character, Integer> window, int start, String S) {
        while(true) {
            if(window.containsKey(S.charAt(start))) {
                if(window.get(S.charAt(start)) >= 0) return start;
                else window.put(S.charAt(start), window.get(S.charAt(start++)) + 1);
            }
            else ++start;
        }
    }
}
