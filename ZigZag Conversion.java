public class Solution {
    public String convert(String s, int nRows) {
        if(nRows == 1) return s;
        StringBuilder resultSB = new StringBuilder();
        int t = 2 * nRows - 2;
        for(int curRow = 0; curRow < nRows; ++curRow) {
            if(curRow == 0 || curRow == nRows - 1) {
                int it = 0;
                while(it < s.length()) {
                    if(it + curRow < s.length()) resultSB.append(s.charAt(it + curRow));
                    it += t;
                }
            } else {
                int it = 0;
                while(it < s.length()) {
                    if(it + curRow < s.length()) resultSB.append(s.charAt(it + curRow));
                    if(it + t - curRow < s.length()) resultSB.append(s.charAt(it + t - curRow));
                    it += t;
                }
            }
        }
        return resultSB.toString();
    }
}
