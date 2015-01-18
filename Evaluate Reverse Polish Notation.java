public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<Integer>();
        for(String s : tokens) {
            if(s.length() == 1 && isOperater(s)) {
                int num1 = stk.pop();
                int num2 = stk.pop();
                stk.push (cal(num2, num1, s));
            }
            else  stk.push(Integer.parseInt(s));
        }
        return stk.pop();
    }
    boolean isOperater(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
    int cal(int num1, int num2, String s) {
        switch (s) {
            case "+" :
                return num1 + num2;
            case "-" : 
                return num1 - num2;
            case "*" :
                return num1 * num2;
            case "/" :
                return num1 / num2;
        }
        return 0;
    }
}
