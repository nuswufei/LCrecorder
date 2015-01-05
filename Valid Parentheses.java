public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        for(int i = 0; i < s.length(); ++i) {
            if(isLeft(s.charAt(i))) stk.push(s.charAt(i));
            else {
                if(stk.empty() || !isMatch(stk.pop(), s.charAt(i))) return false;
            }
        }
        return stk.empty();
    }
    private boolean isLeft(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }
    private boolean isMatch(char ch1, char ch2) {
        return (ch1 == '(' && ch2 == ')') || (ch1 == '[' && ch2 == ']') ||(ch1 == '{' && ch2 == '}');
    }
}
